package problem1;

import java.util.Scanner;

public class prob5_editString {
    public static void main(String args[]){
        String input1, input2;
        Scanner sc = new Scanner(System.in);
        input1 = sc.nextLine();
        input2 = sc.nextLine();

        System.out.println(check(input1, input2));

    }
    public static boolean checkAddandDelete(String A, String B){
        boolean checkVal = false;
        if(A.length() - B.length() == 1 || B.length() - A.length() == 1 || B.length() == A.length()){
            if(A.contains(B) || B.contains(A)){
                checkVal = true;
            }
        }
        return checkVal;
    }

    public static boolean checkReplace(String A, String B){
        char[] c1 = A.toCharArray();
        char[] c2 = B.toCharArray();
        int count = 0;
        boolean checkVal = false;

        if(A.length() == B.length()){
            for(int i = 0; i<A.length(); i++){
                if(c1[i] != c2[i]){
                    count ++;
                }
            }

        }
        if(count <= 1){
            checkVal = true;
        }
        return checkVal;
    }

    public static boolean check(String A, String B){
        boolean checkVal = false;
        if(checkAddandDelete(A,B) || checkReplace(A,B)){
            checkVal = true;
        }
        return checkVal;
    }
}
