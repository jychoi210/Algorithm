package Chap1.Arrays_and_Strings;

import java.util.Scanner;

public class prob6_compressString {
    public static void main(String args[]){
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();

        System.out.println(zip(input));
    }

    public static String zip(String input){
        String[] num = input.split("");
        String result = "";
        int count = 1;

        for(int i = 0; i< input.length()-1; i++){
            if(num[i].equals(num[i+1])){
                count++;
            }else{
                result = result + "" + num[i] + "" + count;
                count = 1;
            }

            if(i == input.length()-2){
                result = result + "" + num[i] + "" + count;
            }
        }

        if (result.length() > input.length()){
            result = input;
        }

        return result;
    }
}
