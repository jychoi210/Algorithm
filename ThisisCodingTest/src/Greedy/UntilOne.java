package Greedy;

// 이것이 코딩 테스트다.
// 그리디 03-4 1이 될 때 까지

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UntilOne {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int result = 0;

        while(N != 1){
            if(N % K == 0){
                N = N / K;
            }else{
                N = N - 1;
            }
            result += 1;
        }
        System.out.print(result);
    }
}
