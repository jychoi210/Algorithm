package problem2;

import java.util.LinkedList;

public class prob3_deleteMidNode {
    public static void main(String args[]){
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        int size = list.size()/2;

        list.remove(size);

        for(String item : list){
            System.out.println(item);
        }
    }
}
