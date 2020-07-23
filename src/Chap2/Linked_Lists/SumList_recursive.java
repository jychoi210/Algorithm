package Chap2.Linked_Lists;

public class SumList_recursive {
    public static void main(String args[]){
        LinkedList a = new LinkedList();
        a.insertNode(1);
        a.insertNode(8);

        LinkedList b = new LinkedList();
        b.insertNode(6);
        b.insertNode(7);
        b.insertNode(9);
        b.insertNode(9);

        SumList_recursive(a.head,b.head).printList();

    }
    public static LinkedList SumList_recursive(ListNode a, ListNode b){
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
            result = differentLength(count,result,b);
        }else{
           result = differentLength(count,result,a);
        }

        if(count == 1){
            result.insertNode(1);
        }

        return result;

    }
    public static LinkedList differentLength(int count, LinkedList result, ListNode node){
        while(node != null){
            if(count == 1) {
                if((int)node.data+1 >= 10){
                    result.insertNode((int)node.data + 1 - 10);
                    count = 1;
                }else {
                    result.insertNode((int)node.data + 1);
                    count = 0;
                }
            }else {
                result.insertNode(node.data);
            }
            node = node.next;
        }

        return result;
    }
}
