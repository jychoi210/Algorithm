package Chap2.Linked_Lists;

public class prob7_Intersection {
    public static void main (String args[]){
        LinkedList list1 = new LinkedList();
        list1.insertNode(1);
        list1.insertNode(2);
        list1.insertNode(3);
        list1.insertNode(4);
        list1.insertNode(5);
        list1.insertNode(6);
        list1.insertNode(7);
        list1.insertNode(7);
        ListNode node1 = list1.head;

        LinkedList list2 = new LinkedList();
        list2.insertNode(10);
        list2.insertNode(9);
        list2.insertNode(8);
        list2.insertNode(1);
        list2.insertNode(7);
        ListNode node2 = list2.head;
        node2.next.next.next.next = node1.next.next.next;

        list1.printList();
        list2.printList();

        ListNode node = isHasIntersection(node1, node2);

        while(node != null){
            System.out.print(node.data);
            node = node.next;
        }

    }

    public static ListNode isHasIntersection(ListNode n1, ListNode n2){
        if(length(n1) > length(n2)){
            for(int i = 0 ; i < length(n1) - length(n2); i++){
                n1 = n1.next;
            }
        }else{
            for(int i = 0 ; i < length(n2) - length(n1); i++){
                n2 = n2.next;
            }
        }

        while(n1 != null && n2 != null){
            if(n1 == n2){
                return n1;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return null;
    }
    
    public static int length(ListNode node){
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }
}
