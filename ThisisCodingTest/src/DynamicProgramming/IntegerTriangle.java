package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 16 : 다이나믹 프로그래밍 기출 2 정수 삼각형
// https://www.acmicpc.net/problem/1932

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle {
    public static int n;
    public static int[][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int left,right;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0) right = 0;
                else right = dp[i-1][j-1];

                if(j == i) left = 0;
                else left = dp[i-1][j];

                dp[i][j] = dp[i][j] + Math.max(left,right);
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            result = Math.max(result, dp[n-1][i]);
        }

        System.out.print(result);
    }
}
