package Chap2.Linked_Lists;

import java.util.HashSet;

public class prob1_deleteDuplicate {
    public static void main(String args[]){
        LinkedList linkedList = new LinkedList();
        linkedList.insertNode("a");
        linkedList.insertNode("c");
        linkedList.insertNode("e");
        linkedList.insertNode("a");
        linkedList.insertNode("e");
        linkedList.insertNode("f");
        linkedList.insertNode("c");


        deleteDuplicate(linkedList.head);

        linkedList.printList();

    }

    public static void deleteDuplicate(ListNode n){
        HashSet<Object> hashSet = new HashSet<>();
        ListNode prev = null;
        while(n!=null){
            if(hashSet.contains(n.data)){
                prev.next = n.next;
            }else{
                hashSet.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }
}
