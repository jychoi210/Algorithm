import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class myStack<Integer> {
    class StackNode {
        int data;
        StackNode next;

        public StackNode(int data) {
            this.data = data;
        }
    }

    StackNode top;
    int size;

    public void push(int item) {
        StackNode t = new StackNode(item);
        t.next = top;
        top = t;
        size++;
    }

    public int pop() {
        if(size <= 0) return -1;
        else{
            int item = top.data;
            top = top.next;
            size--;
            return item;
        }
    }

    public int top() {
        if (top == null) return -1;
        else return top.data;
    }

    public int empty(){
        if(top == null) return 1;
        else return 0;
    }

    public int size(){
        return size;
    }
}

public class bj_stack1 {
    public static void main(String args[]) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int commandNum = Integer.parseInt(reader.readLine());
        myStack<Integer> stack = new myStack<>();

        for(int i = 0; i < commandNum; i++){
            String command = reader.readLine();
            if(command.contains("push")){
                stack.push(Integer.parseInt(command.substring(5)));
            }else if(command.equals("pop")){
                writer.write(Integer.toString(stack.pop()));
                writer.newLine();
            }else if(command.equals("size")){
                writer.write(Integer.toString(stack.size()));
                writer.newLine();
            }else if(command.equals("empty")){
                writer.write(Integer.toString(stack.empty()));
                writer.newLine();
            }else if(command.equals("top")){
                writer.write(Integer.toString(stack.top()));
                writer.newLine();
            }
        }
        writer.flush();
        writer.close();

    }
}

