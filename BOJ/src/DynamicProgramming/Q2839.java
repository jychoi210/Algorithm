package DynamicProgramming;

// 백준 다이나믹 프로그래밍 Q2839 설탕배달

import java.util.Arrays;
import java.util.Scanner;

public class Q2839 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //설탕량 입력 받기
        int N = sc.nextInt();
        //dp 테이블 생성
        int[] dp = new int[N + 1];

        //dp 테이블 초기화
        Arrays.fill(dp, 5001);

        dp[0] = 0;
        //봉지 종류가 2가지 이므로 반복
        //k = 3 or 5
        for(int i = 0; i < 2; i++){
            int k = i * 2 + 3;
            //dp[j-k]가 무한의 값이 아니라면, dp[j]과 dp[j-k]+1의 값 중 작은 것으로 갱신
            for(int j = k; j < N + 1; j++){
                if(dp[j - k] != 5001){
                    dp[j] = Math.min(dp[j],dp[j - k] + 1);
                }
            }
        }

        //봉지 개수 출력 (dp테이블 값이 무한이라면, -1 출력)
        System.out.print(dp[N] != 5001 ? dp[N] : -1);
    }
}
