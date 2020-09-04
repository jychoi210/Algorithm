package Chap3.Stack_and_Queue;

import java.util.Stack;

//import CtCILibrary.AssortedMethods;

public class prob5_solution {
    public static void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()) {
            /* Insert each element in s in sorted order into r. */
            int tmp = s.pop();
            while(!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }

        /* Copy the elements back. */
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }

    public static void main(String [] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(7);
        s.push(3);
        s.push(8);
        s.push(4);

        sort(s);

        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
