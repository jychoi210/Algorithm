package Chap1.Arrays_and_Strings;

import java.util.Arrays;
import java.util.Scanner;

public class prob9_reverseString {
    public static void main(String args[]){
        String s1, s2, s3 = "";
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        s1 = sc.nextLine();
        s2 = sc.nextLine();
        String[] words = s2.split("");

        if(s1.length() == s2.length()){

            s3 = joinwords(words);
            check = isSubstring(s1,s3);
        }
        System.out.println(check);
    }

    public static String joinwords(String[] word){
        StringBuilder sentence = new StringBuilder();
        for(String temp : word){
            sentence.append(temp);
        }
        sentence.append(sentence);
        return sentence.toString();
    }
    public static boolean isSubstring(String s1, String s2){
        return (s1.contains(s2) || s2.contains(s1));
    }
}
