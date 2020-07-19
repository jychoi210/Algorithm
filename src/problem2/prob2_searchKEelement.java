package problem2;

import java.util.LinkedList;
import java.util.Scanner;

public class prob2_searchKEelement {
    public static void main(String args[]){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        
        int k;
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        
        int size = list.size()-k+1;
        int result = 0;
        
        for(int i = 0; i < size; i++){
            result = list.get(i);
        }
        
        System.out.println(result);
    }
}
