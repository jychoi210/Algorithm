package DynamicProgramming;

// 백준 다이나믹 프로그래밍 Q2839 설탕배달

import java.util.Arrays;
import java.util.Scanner;

public class Q2839 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        Arrays.fill(dp, 5001);

        dp[0] = 0;
        for(int i = 0; i < 2; i++){
            int k = i * 2 + 3;
            for(int j = k; j < N + 1; j++){
                if(dp[j - k] != 5001){
                    dp[j] = Math.min(dp[j],dp[j - k] + 1);
                }
            }
        }

        System.out.print(dp[N] != 5001 ? dp[N] : -1);
    }
}
