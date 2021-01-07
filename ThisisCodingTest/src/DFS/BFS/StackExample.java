package DFS.BFS;

import java.util.Stack;

public class StackExample {
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();

        s.push(5);
        s.push(2);
        s.push(3);
        s.push(7);
        s.pop();
        s.push(1);
        s.push(4);
        s.pop();

        //스택 최상단부터 출력
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
