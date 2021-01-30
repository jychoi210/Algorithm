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
        //n 입력 받기
        n = Integer.parseInt(br.readLine());
        //dp 테이블 생성
        dp = new int[n][n];

        //dp 테이블 입력 받기 (정수 삼각형 입력 받기)
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //왼쪽에서 내려온 것, 오른쪽에서 내려온 것
        int left,right;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                //j가 0이라면, 즉 맨 앞쪽이라면 right는 0
                if(j == 0) right = 0;
                else right = dp[i-1][j-1];

                //j가 i라면, 즉 맨 끝쪽이라면 left는 0
                if(j == i) left = 0;
                else left = dp[i-1][j];

                // dp[i][j]는 왼쪽, 오른쪽 중 큰 것 더하기
                dp[i][j] = dp[i][j] + Math.max(left,right);
            }
        }

        //마지막 줄에서 가장 큰 수가 최댓값, 그 수 출력
        int result = 0;
        for(int i = 0; i < n; i++){
            result = Math.max(result, dp[n-1][i]);
        }

        System.out.print(result);
    }
}
