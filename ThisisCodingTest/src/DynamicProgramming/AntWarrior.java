package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 8 : 다이나믹 프로그래밍 문제 2 개미 전사

import java.util.Scanner;

public class AntWarrior {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] wareHouse = new int[N + 1];
        for(int i = 0; i < N; i++){
            wareHouse[i] = sc.nextInt();
        }

        int[] dp = new int[N + 1];
        dp[0] = wareHouse[0];
        dp[1] = Math.max(wareHouse[0],wareHouse[1]);
        if(N > 2){
            for(int i = 3; i <= N; i++){
                dp[i] = Math.max(dp[i-3]+wareHouse[i-1],dp[i-2]+wareHouse[i]);
                //마지막에 추가될 칸을 선택하면 dp[i-2]+wareHouse[i], 선택하지 않으면 dp[i-1]로 계산하면 아래와 같이 점화식 사용 가능
                //dp[i] = Math.max(dp[i-1],dp[i-2]+wareHouse[i]);
                //즉, dp[i-3]+wareHouse[i-1] = dp[i-1]이다.
            }
        }

        System.out.print(dp[N-1]);
    }
}
