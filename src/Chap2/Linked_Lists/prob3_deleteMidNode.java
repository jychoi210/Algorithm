package Chap2.Linked_Lists;

public class prob3_deleteMidNode {
    public static void main(String args[]){
        LinkedList linkedList = new LinkedList();
        linkedList.insertNode("a");
        linkedList.insertNode("p");
        linkedList.insertNode("p");
        linkedList.insertNode("l");
        linkedList.insertNode("e");
        linkedList.insertNode("p");
        linkedList.insertNode("i");
        linkedList.insertNode("e");

        if(deleteMiddleNode(linkedList.head.next.next.next)){
            linkedList.printList();
        }
    }

    public static boolean deleteMiddleNode(ListNode n){
        if(n.next == null || n == null){
            return false;
        }
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }
}
