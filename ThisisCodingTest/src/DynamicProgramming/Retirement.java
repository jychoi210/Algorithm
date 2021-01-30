package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 16 : 다이나믹 프로그래밍 기출 3 퇴사
// 삼성전자 SW 역량 테스트
// https://www.acmicpc.net/problem/14501

//i번째 날부터 마지막 날 까지의 최대 금액

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retirement {
    public static int n;
    public static int[] T, P, dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n 입력 받기
        n = Integer.parseInt(br.readLine());

        //상담을 완료하는 데 걸리는 기간
        T = new int[n];
        //상담을 했을 때 받을 수 있는 금액
        P = new int[n];
        //dp 테이블
        dp = new int[n+1];

        //기간과 금액 입력 받기
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        //i번째 날부터 마지막 날 까지의 최대 금액
        for(int i = n-1; i >= 0; i--){
            int time = T[i] + i;
            //만약 상담 끝나는 날이 퇴사 전이면
            if(time <= n){
                //현재 i번째 날의 상담을 받을지 말지 결정
                dp[i] = Math.max(P[i]+dp[time], dp[i+1]);
            }else{
                //현재 최댓값을 그대로 저장
                dp[i] = dp[i+1];
            }
        }
        System.out.print(dp[0]);
    }
}
