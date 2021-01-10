package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 8 : 다이나믹 프로그래밍 문제 3 바닥 공사

import java.util.Scanner;

public class FloorWork {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N];

        dp[0] = 1;
        dp[1] = 3;
        if(N > 2){
            for(int i = 2; i < N; i++){
                dp[i] = ( dp[i-1] + dp[i-2] * 2 ) % 796796;
            }
        }

        System.out.print(dp[N-1]);
    }
}
