//fastcampus 자료구조 강의 36
//Binary Search Tree 이진 탐색 트리

class Node{
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class BinaryTree{

    public Node insertNode(Node root, int data){
        Node head = root;

        if(head == null){
            return new Node(data);
        }else{
            if(root.data > data){
                root.leftChild = insertNode(root.leftChild, data);
            }else{
                root.rightChild = insertNode(root.rightChild, data);
            }
        }
        return root;
    }

    public Node searchNode(Node root, int data){
        if(root == null) return null;
        System.out.println("탐색 순서 : " + root.data);
        if(root.data == data) return root;
        else if(root.data > data) return searchNode(root.leftChild, data);
        else return searchNode(root.rightChild, data);
    }

    public void preorder(Node root){
        if(root == null) return;
        System.out.println(root.data);
        preorder(root.leftChild);
        preorder(root.rightChild);
    }

    public void inorder(Node root){
        if(root == null) return;
        inorder(root.leftChild);
        System.out.println(root.data);
        inorder(root.rightChild);
    }

    public void postorder(Node root){
        if(root == null) return;
        postorder(root.leftChild);
        postorder(root.rightChild);
        System.out.println(root.data);
    }

    public Node findMinNode(Node root){
        Node node = root;
        while(node.leftChild != null){
            node = node.leftChild;
        }
        return node;
    }

    public Node deleteNode(Node root, int data){
        Node node = null;
        if(root == null) return null;
        if(root.data > data) root.leftChild = deleteNode(root.leftChild, data);
        else if(root.data < data) root.rightChild = deleteNode(root.rightChild, data);
        else{
            //자식 2개인 경우
            if(root.leftChild != null && root.rightChild != null){
                node = findMinNode(root.rightChild);
                root.data = node.data;
                root.rightChild = deleteNode(root.rightChild, node.data);
            }
            //자식이 1개거나 없는 경우
            else{
                node = (root.leftChild != null) ? root.leftChild : root.rightChild;
                return node;
            }
        }
        return root;
    }
}

public class BinarySearchTree {
    public static void main(String args[]){
        BinaryTree binaryTree = new BinaryTree();
        Node root = null;

        root = binaryTree.insertNode(root, 30);
        binaryTree.insertNode(root, 17);
        binaryTree.insertNode(root, 48);
        binaryTree.insertNode(root, 5);
        binaryTree.insertNode(root, 23);
        binaryTree.insertNode(root, 37);
        binaryTree.insertNode(root, 50);
        binaryTree.deleteNode(root, 30);
        binaryTree.preorder(root);

        Node test = binaryTree.searchNode(root, 5);
        String result = (test != null) ? "탐색 성공" : "탐색 실패";
        System.out.println(result);

    }
}
