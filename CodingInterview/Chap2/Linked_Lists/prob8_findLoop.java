package Chap2.Linked_Lists;

import java.util.HashSet;

public class prob8_findLoop {
    public static void main(String args[]){
        LinkedList linkedList = new LinkedList();
        linkedList.insertNode(1);
        linkedList.insertNode(2);
        linkedList.insertNode(3);
        linkedList.insertNode(4);
        linkedList.insertNode(5);
        linkedList.insertNode(6);
        ListNode node = linkedList.head;
        node.next.next.next.next.next = node.next.next;

        System.out.println(isHasLoop(node).data);

    }

    public static ListNode isHasLoop(ListNode node){
        HashSet<ListNode> hashSet = new HashSet<>();
        while(node != null){
            if(!hashSet.contains(node)){
                hashSet.add(node);
            }else{
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
