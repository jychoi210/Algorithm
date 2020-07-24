package Chap2.Linked_Lists;

import java.util.LinkedList;
import java.util.Scanner;

public class prob4_divide {
    public static void main(String args[]) {
        int k = 0;
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(10);
        list.add(2);
        list.add(1);

        list = divide(list, k);

        for (int item : list) {
            System.out.println(item);
        }
    }

    public static LinkedList<Integer> divide(LinkedList<Integer> list, int k) {
        int in = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < k) {
                if (i < list.indexOf(k)) {
                    in++;
                } else {
                    int temp = list.get(i);
                    list.set(i, list.get(in + 1));
                    list.set(in + 1, temp);
                    in++;
                }
            }

        }

        return list;
    }
}
