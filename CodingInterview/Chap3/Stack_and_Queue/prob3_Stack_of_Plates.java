package Chap3.Stack_and_Queue;

import java.util.EmptyStackException;

public class prob3_Stack_of_Plates {
    public static class SetOfStacks<Object>{
        class StackNode<Object>{
            String data;
            StackNode next;
            public StackNode(String data){
                this.data = data;
            }
        }

        StackNode[] top = new StackNode[2];
        int stack_size = 0;
        int stackNum = 0;

        public String pop(){
            if(top[stackNum] == null) stackNum--;
            if(top[0] == null) throw new EmptyStackException();
            String item = top[stackNum].data;
            top[stackNum] = top[stackNum].next;
            return item;
        }

        public void push(String item){
            StackNode t = new StackNode(item);
            t.next = top[stackNum];
            top[stackNum] = t;
            stack_size++;
            if(stack_size == 10){
                stackNum++;
            }
        }

        public String popAt(int stackIndex){
            if(top[stackNum]== null) throw new EmptyStackException();
            String item = top[stackIndex].data;
            top[stackIndex] = top[stackIndex].next;
            return item;
        }
    }

    public static void main(String args[]){
        SetOfStacks<String> setOfStacks = new SetOfStacks();
        setOfStacks.push("a");
        setOfStacks.push("b");
        setOfStacks.push("c");
        setOfStacks.push("d");
        setOfStacks.push("e");
        setOfStacks.push("f");
        setOfStacks.push("g");
        setOfStacks.push("h");
        setOfStacks.push("i");
        setOfStacks.push("j");
        setOfStacks.push("k");
        setOfStacks.push("l");

        /*
        while(true){
            if(setOfStacks.top[1] == null) break;
            System.out.println("stack 1 : " + setOfStacks.pop());
        }
        while(true){
            if(setOfStacks.top[0] == null) break;
            System.out.println("stack 0 : " + setOfStacks.pop());
        }
         */

    }
}
