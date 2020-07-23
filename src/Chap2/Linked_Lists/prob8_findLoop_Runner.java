package Chap2.Linked_Lists;

import java.util.HashSet;

public class prob8_findLoop_Runner {
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

        if(isHasLoop(node)){
            String result = (searchLoopNode(linkedList) != null ? ""+ searchLoopNode(linkedList).data : "No Loop");
            System.out.println(result);
        }
    }

    public static ListNode searchLoopNode(LinkedList linkedList){
        ListNode faster = linkedList.head;
        ListNode slower = linkedList.head;

        faster = faster.next.next;
        slower = slower.next;

        while(faster != null){
            if(faster == slower){
                break;
            }
            faster = faster.next.next;
            slower = slower.next;
        }

        slower = linkedList.head;

        while(faster != null){
            if(faster == slower){
                return faster;
            }
            faster = faster.next;
            slower = slower.next;
        }
        return null;

    }
    public static boolean isHasLoop(ListNode node){
        HashSet<ListNode> hashSet = new HashSet<>();
        while(node != null){
            if(!hashSet.contains(node)){
                hashSet.add(node);
            }else{
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
