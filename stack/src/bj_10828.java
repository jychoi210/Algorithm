//정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

//push X: 정수 X를 스택에 넣는 연산이다.
//pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 스택에 들어있는 정수의 개수를 출력한다.
//empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
//top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

//첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.

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

public class bj_10828 {
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

