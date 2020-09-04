package Chap3.Stack_and_Queue;

public class prob5_Stack_Sort {
    public static class MyStack<Integer>{
        class StackNode{
            int data;
            StackNode next;
            public StackNode(int data){
                this.data = data;
            }
        }

        StackNode top;

        public int pop(){
            int item = top.data;
            top = top.next;
            return item;
        }

        public void push(int item){
            StackNode t = new StackNode(item);
            t.next = top;
            top = t;
        }

        public int peek(){
            return top.data;
        }

        public boolean isEmpty(){
            if(top == null) return true;
            return false;
        }
    }
    public static void main(String args[]){
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(6);
        myStack.push(1);
        myStack.push(9);
        myStack.push(8);

        MyStack result = stackSort(myStack);

        while(!result.isEmpty()){
            System.out.println(result.pop());
        }

        

    }
    public static MyStack stackSort(MyStack myStack){
        MyStack resultStack = new MyStack();
        int max = myStack.top.data;
        while(!myStack.isEmpty()){
            if(max < myStack.top.data){
                max = myStack.top.data;
            }
            resultStack.push(max);
            myStack.top = myStack.top.next;
        }
        return resultStack;
    }
    public static void maxpop(MyStack myStack){
        MyStack resultStack = new MyStack();
        int max = myStack.top.data;
        while(!myStack.isEmpty()){
            if(max < myStack.top.data){
                max = myStack.top.data;
            }

            myStack.top = myStack.top.next;
        }

    }
}
