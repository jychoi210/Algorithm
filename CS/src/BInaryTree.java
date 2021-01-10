//fastcampus 자료구조 강의 30
//Binary Search Tree 이진 강트리의 구현 및 순회

class Node2{
    int data;
    Node2 leftChild;
    Node2 rightChild;

    public Node2(int data, Node2 leftChild, Node2 rightChild){
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public  void preorder(Node2 root){
        if(root != null){
            System.out.println(root.data);
            preorder(root.leftChild);
            preorder(root.rightChild);
        }
    }

    public  void inorder(Node2 root){
        if(root != null){
            inorder(root.leftChild);
            System.out.println(root.data);
            inorder(root.rightChild);
        }
    }

    public  void postorder(Node2 root){
        if(root != null){
            postorder(root.leftChild);
            postorder(root.rightChild);
            System.out.println(root.data);
        }
    }

}

public class BInaryTree {
    public static void main(String args[]){
        Node2 n7 = new Node2(50,null,null);
        Node2 n6 = new Node2(37,null,null);
        Node2 n5 = new Node2(23,null,null);
        Node2 n4 = new Node2(5,null,null);
        Node2 n3 = new Node2(48,n6,n7);
        Node2 n2 = new Node2(17,n4,n5);
        Node2 n1 = new Node2(30,n2,n3);

        n1.preorder(n1);
        System.out.println("\n");
        n1.inorder(n1);
        System.out.println("\n");
        n1.postorder(n1);

    }
}
