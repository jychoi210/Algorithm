package problem;

import java.util.*;

public class prob1_4_1 {
    public static void main(String args[]){
        String input;
        Scanner sc = new Scanner(System.in);

        input = sc.nextLine();
        String[] A;
        input = input.replace(" ", "");
        A = input.split("");

        System.out.println(check(A));

    }

    public static ArrayList delete(String[] input){
        HashSet<String> set = new HashSet<>();
        for (String temp : input) {
            set.add(temp);
        }

        ArrayList<String> data = new ArrayList<>(set);

        return data;
    }

    public static int[] countChar(String[] input){
        ArrayList<String> data = delete(input);

        String result = "";

        int[] B = new int[data.size()];

        for(String temp : input){
            if(result.contains(temp)) {
                result = result + temp;
                int i = data.indexOf(temp);
                B[i]++;
            }else{
                result = result + temp;
                int i = data.indexOf(temp);
                B[i] = 1;
            }
        }

        return B;
    }

    public static boolean check(String[] input){
        ArrayList<String> data = delete(input);

        int B[] = countChar(input);

        int count = 0;
        boolean checkVal = false;

        for(int i : B){
            if(i % 2 == 0){
                count++;
            }
        }

        if (count == data.size() || count == data.size()-1){
            checkVal = true;
        }

        return checkVal;
    }
}
