//fastcampus 자료구조 강의 37
//AVL Tree

class Node3{
    int data;
    int height;
    Node3 leftChild;
    Node3 rightChild;

    public Node3(int data){
        this.data = data;
        this.height = 1;
        this.leftChild = null;
        this.rightChild = null;
    }
}

public class AVLTree {

    Node3 root = null;

    public int getMax(int a, int b){
        if(a > b) return a;
        else return b;
    }

    public int getHeight(Node3 node){
        if(node == null) return 0;
        return node.height;
    }

    public void setHeight(Node3 node){
        node.height = getMax(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
    }

    public int getDifferecnce(Node3 node){
        if(node == null) return 0;
        Node3 leftChild = node.leftChild;
        Node3 rightChild = node.rightChild;
        return getHeight(leftChild) - getHeight(rightChild);
    }

    public Node3 rotateLL(Node3 node){
        Node3 leftChild = node.leftChild;
        node.leftChild = leftChild.rightChild;
        leftChild.rightChild = node;
        setHeight(node);
        return leftChild;
    }

    public Node3 rotateRR(Node3 node){
        Node3 rightChild = node.rightChild;
        node.rightChild = rightChild.leftChild;
        rightChild.leftChild = node;
        setHeight(node);
        return rightChild;
    }

    public Node3 rotateLR(Node3 node){
        Node3 leftChild = node.leftChild;
        node.leftChild = rotateRR(leftChild);
        return rotateLL(node);
    }

    public Node3 rotateRL(Node3 node){
        Node3 rightChild = node.rightChild;
        node.rightChild = rotateLL(rightChild);
        return rotateRR(node);
    }

    //트리 균형 맞추기
    public Node3 balance(Node3 node){
        int differ = getDifferecnce(node);
        //불균형이면
        if(differ >= 2){
            //node의 왼쪽 자식이 더 많으면 LL회전
            if(getDifferecnce(node.leftChild) >= 1) {
                node = rotateLL(node);
            }else{
                node = rotateLR(node);
            }
        }else if(differ <= -2){
            if(getDifferecnce(node.rightChild) <= -1){
                node = rotateRR(node);
            }else{
                node = rotateRL(node);
            }
        }
        //꼭 회전 후에 높이 다시 계산해주어야 함.
        setHeight(node);
        return node;
    }

    public Node3 insertNode(Node3 node, int data){
        if(node == null){
            return (new Node3(data));
        }
        else if (node.data > data) {
            node.leftChild = insertNode(node.leftChild, data);
            node = balance(node);
        } else if (node.data < data) {
            node.rightChild = insertNode(node.rightChild, data);
            node = balance(node);
        } else {
            System.out.println("데이터 중복이 발생했습니다.\n");
        }
        return node;
    }

    public void display(Node3 node, int level){
        if(node != null){
            display(node.rightChild, level+1);
            System.out.print("\n");
            if(node == root){
                System.out.print("Root: ");
            }
            for (int i = 0; i < level && node != root; i++){
                System.out.print("      ");
            }
            System.out.print(node.data+"("+getHeight(node)+")");
            display(node.leftChild, level+1);
        }
    }

    public static void main(String args[]){
        AVLTree avlTree = new AVLTree();
        Node3 root = null;
        root = avlTree.insertNode(root,7);
        root = avlTree.insertNode(root, 6);
        root = avlTree.insertNode(root, 5);
        root = avlTree.insertNode(root, 3);
        root = avlTree.insertNode(root, 1);
        root = avlTree.insertNode(root, 9);
        root = avlTree.insertNode(root, 8);
        root = avlTree.insertNode(root, 12);
        root = avlTree.insertNode(root, 16);
        root = avlTree.insertNode(root, 18);
        root = avlTree.insertNode(root, 23);
        root = avlTree.insertNode(root, 21);
        root = avlTree.insertNode(root, 14);
        root = avlTree.insertNode(root, 15);
        root = avlTree.insertNode(root, 19);
        root = avlTree.insertNode(root, 20);
        avlTree.display(root, 1);
        System.out.println("\n");

    }
}
