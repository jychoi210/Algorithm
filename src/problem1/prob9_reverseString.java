package problem1;

import java.util.Scanner;

public class prob9_reverseString {
    public static void main(String args[]){
        String s1, s2 = "";
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        s1 = sc.nextLine();
        s2 = sc.nextLine();

        if(s1.length() == s2.length()){
            s2 = new StringBuffer(s2).reverse().toString();
            check = isSubstring(s1,s2);
        }

        System.out.println(check);

    }

    public static boolean isSubstring(String s1, String s2){
        return (s1.contains(s2) || s2.contains(s1));
    }
}
