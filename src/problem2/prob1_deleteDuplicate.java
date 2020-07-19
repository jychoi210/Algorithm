package problem2;

import java.util.LinkedList;

public class prob1_deleteDuplicate {
    public static void main(String args[]){
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        list.add(1);
        list.add(3);
        list.add(9);
        list.add(7);
        list.add(1);
        list.add(3);

        for(int i = 0; i < list.size() ; i++) {
            if (!result.contains(list.get(i))) {
                result.add(list.get(i));
            }
        }

        for(int item : result) {
            System.out.println(item);
        }

    }
}
