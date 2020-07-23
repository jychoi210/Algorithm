package Chap2.Linked_Lists;

public class prob5_SumList_reverse {
    public static void main(String args[]){
        LinkedList a = new LinkedList();
        a.insertNode(9);
        a.insertNode(8);

        LinkedList b = new LinkedList();
        b.insertNode(6);
        b.insertNode(7);


        SumList_reverse(a.head,b.head).printList();

    }
    public static LinkedList SumList_reverse(ListNode a, ListNode b){
        int count = 0;
        LinkedList result = new LinkedList();

        while(a != null && b != null){
            if((int)a.data + (int)b.data < 10){
                result.insertNode((int)a.data + (int)b.data + count);
                count = 0;
            }else{
                result.insertNode((int)a.data + (int)b.data - 10 + count);
                count = 1;
            }
            a = a.next;
            b = b.next;
        }

        if(a == null){
            while(b != null){
                if(count == 1) {
                    if((int)b.data+1 >= 10){
                        result.insertNode((int)b.data+1 - 10);
                        count = 1;
                    }else {
                        result.insertNode((int) b.data + 1);
                        count = 0;
                    }
                }else {
                    result.insertNode(b.data);
                }
                b = b.next;
            }
        }else{
            while(a != null){
                if(count == 1) {
                    if((int)a.data+1 > 10){
                        result.insertNode((int)a.data + 1 - 10);
                        count = 1;
                    }else {
                        result.insertNode((int) a.data + 1);
                        count = 0;
                    }
                }else {
                    result.insertNode(a.data);
                }
                a = a.next;
            }

        }

        if(count == 1){
            result.insertNode(1);
        }

        return result;

    }
}
