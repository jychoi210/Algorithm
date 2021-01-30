package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 16 : 다이나믹 프로그래밍 기출 4 병사 배치하기 해답
// https://www.acmicpc.net/problem/18353

//LIS(Longest Increasing Subsequence) 가장 긴 증가하는 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DeployingSoldiers_sol {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n 입력 받기
        int n = Integer.parseInt(br.readLine());

        //병사 정보 배열
        int[] arr = new int[n];
        //dp 테이블
        int[] dp = new int[n];

        //dp 테이블 1로 초기화
        Arrays.fill(dp, 1);

        //병사 정보 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = n - 1; i >= 0; i--){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //arr[i]가 마지막 원소가 되는 최대 부분 수열 구하기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //최대 길이 구하기
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.print(n-max);
    }
}
