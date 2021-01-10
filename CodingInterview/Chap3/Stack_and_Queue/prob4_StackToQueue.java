package Chap3.Stack_and_Queue;

import java.util.EmptyStackException;
class MyStack<Integer>{
    class StackNode{
        int data;
        StackNode next;
        public StackNode(int data){
            this.data = data;
        }
    }

    StackNode top;

    public void push(int item){
        StackNode t = new StackNode(item);
        t.next = top;
        top = t;
    }

    public int pop(){
        int item = top.data;
        top = top.next;
        return item;
    }

    public int peek(){
        if(top == null) throw new EmptyStackException();
        return top.data;
    }
}

public class prob4_StackToQueue {
    public static class MyQueue<T>{
        MyStack myStack;
        MyStack resultStack;

        public MyQueue(){
            myStack = new MyStack();
            resultStack = new MyStack();
        }

        public void add(int item){
            myStack.push(item);
        }

        public void change(){
            if(resultStack.top == null) {
                while (myStack.top != null) {
                    resultStack.push(myStack.pop());
                }
            }
        }

        public void remove(){
            change();
            resultStack.pop();
        }

        public int peek(){
            change();
            if(resultStack.top == null) throw new EmptyStackException();
            return resultStack.peek();
        }
    }

    public static void main(String args[]){
        MyQueue<Integer> myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);
        myQueue.add(9);
        myQueue.add(10);

        System.out.println(myQueue.peek());
        myQueue.remove();
        System.out.println(myQueue.peek());
    }
}
