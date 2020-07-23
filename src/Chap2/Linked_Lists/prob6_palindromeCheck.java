package Chap2.Linked_Lists;

public class prob6_palindromeCheck {
    public static void main(String args[]){
        LinkedList linkedList = new LinkedList();
        linkedList.insertNode("r");
        linkedList.insertNode("e");
        linkedList.insertNode("t");
        linkedList.insertNode("r");
        linkedList.insertNode("e" +
                "");
        linkedList.insertNode("e");
        linkedList.insertNode("r");

        boolean check = palindromeCheck(linkedList);

        System.out.println(check);

    }
    public static boolean palindromeCheck(LinkedList linkedList){
        MyStack<String> myStack = new MyStack();
        boolean check = true;
        ListNode node = linkedList.head;

        while(node != null){
            myStack.push((String)node.data);
            node = node.next;
        }

        node = linkedList.head;

        while(!myStack.isEmpty()){
            if(!myStack.pop().equals(node.data)){
                return false;
            }
            node = node.next;
        }

        return check;

    }
}
