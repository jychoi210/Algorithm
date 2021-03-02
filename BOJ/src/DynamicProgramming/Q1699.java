package DynamicProgramming;

// 백준 다이나믹 프로그래밍 Q1699 제곱수의 합
// https://www.acmicpc.net/problem/1699

import java.io.*;
import java.util.*;

public class Q1699 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j*j <= i; j++){
                int tmp = dp[i-j*j] + 1;
                if(dp[i] > tmp || dp[i] == 0){
                    dp[i] = tmp;
                }
            }
        }
        System.out.print(dp[n]);
    }
}
