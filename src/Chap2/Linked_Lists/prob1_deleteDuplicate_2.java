package Chap2.Linked_Lists;

import java.util.LinkedList;
import java.util.ArrayList;

public class prob1_deleteDuplicate_2 {
    public static void main(String args[]){
        LinkedList<Integer> list = new LinkedList<Integer>();
        ArrayList<Integer> duplicate = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = 0;
        list.add(7);
        list.add(3);
        list.add(9);
        list.add(7);
        list.add(1);
        list.add(3);

        for(int i = 0; i < list.size() ; i++) {
            if (!duplicate.contains(list.get(i))) {
                duplicate.add(list.get(i));
            }else{
                result.add(i);
            }
        }
        for(int i = 0; i < result.size(); i++) {
            list.remove(result.get(i) - count);
            count++;
        }

        for(int item : list) {
            System.out.println(item);
        }

    }
}
