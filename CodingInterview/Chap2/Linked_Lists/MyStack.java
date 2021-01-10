package Chap2.Linked_Lists;

import java.util.EmptyStackException;

public class MyStack<T> {
    public class StackNode{
        T data;
        StackNode next;
        StackNode(T data){
            this.data = data;
        }
    }
    public StackNode top;
    public T pop(){
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item){
        StackNode t = new StackNode(item);
        t.next = top;
        top = t;
    }

    public T peek(){
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
