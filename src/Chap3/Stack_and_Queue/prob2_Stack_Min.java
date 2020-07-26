package Chap3.Stack_and_Queue;

import java.util.EmptyStackException;

public class prob2_Stack_Min {
    public static class MyStack<Integer> {
        class StackNode {
            public int data;
            StackNode next;
            StackNode nextMin;

            public StackNode(int data) {
                this.data = data;
            }
        }

        StackNode top;
        StackNode minTop;

        public int pop() {
            if (top == null) throw new EmptyStackException();
            int item = top.data;
            top = top.next;
            minTop = minTop.nextMin;
            return item;
        }

        public void push(int item) {
            StackNode t = new StackNode(item);
            StackNode tMin = new StackNode(item);
            t.next = top;
            tMin.nextMin = minTop;
            top = t;
            minTop = tMin;
            if(minTop.nextMin != null){
                if(minTop.data > minTop.nextMin.data){
                    minTop.data = minTop.nextMin.data;
                }
            }
        }

        public int min() {
            if (minTop == null) throw new EmptyStackException();
            int item = minTop.data;
            return item;
        }
    }

    public static void main(String args[]){
        MyStack<Integer> myStack = new MyStack();
        myStack.push(9);
        myStack.push(6);
        myStack.push(5);
        myStack.push(7);
        myStack.push(4);
        myStack.push(3);
        myStack.push(2);
        myStack.push(1);

        while(true){
            System.out.println("min Value : " + myStack.min());
            System.out.println("pop : " + myStack.pop());

            if(myStack.top == null){
                break;
            }
        }

    }
}
