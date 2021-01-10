package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 8 : 다이나믹 프로그래밍 문제 1 1로 만들기

import java.util.Scanner;

public class MakingItOne {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] dp = new int[x + 1];

        for(int i = 2; i <= x; i++){
            //1 빼는 경우, 연산 횟수 1을 더해서 다음 수에 저장
            dp[i] = dp[i - 1] + 1;
            // 2로 나누는 경우, 원래 값과 2로 나누고 연산 횟수 1을 더한 값 중에 작은 것을 저장
            if(i % 2 == 0) dp[i] = Math.min(dp[i],dp[i/2] + 1);
            // 3으로 나누는 경우, 원래 값과 3으로 나누고 연산 횟수 1을 더한 값 중에 작은 것을 저장
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
            // 5로 나누는 경우, 원래 값과 5로 나누고 연산 횟수 1을 더한 값 중에 작은 것을 저장
            if(i % 5 == 0) dp[i] = Math.min(dp[i], dp[i/5] + 1);
        }

        System.out.print(dp[x]);
    }
}
