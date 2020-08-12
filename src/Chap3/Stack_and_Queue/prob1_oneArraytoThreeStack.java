package Chap3.Stack_and_Queue;

import Chap2.Linked_Lists.MyStack;
import java.util.EmptyStackException;

public class prob1_oneArraytoThreeStack {

    public static void main(String args[]){
        String[] array = new String[30];


    }
    public static void oneArraytoThreeStack(String[] array){

    }

    public static String pop(){
        return null;
    }

    public static boolean push(int StackNum, String[] array){
        int size = array.length/3;
        if(array[size * StackNum - size] != null){
            return false;
        }
        //String
        return true;
    }
}
