package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 8 : 다이나믹 프로그래밍 문제 4 효율적인 화폐 구성 해답

import java.util.Arrays;
import java.util.Scanner;

public class EfficientMoneyComposition_sol {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //화폐 단위 입력받기
        int[] money = new int[n];
        for(int i = 0; i < n; i++){
            money[i] = sc.nextInt();
        }

        //무한대 값(10001)을 모든 배열에 채움
        int[] dp = new int[m+1];
        Arrays.fill(dp,10001);

        dp[0] = 0;
        //화폐 단위 각각 하나씩 확인
        for(int i = 0; i < n; i++){
            //화폐 단위 부터 m까지 확인
            for(int j = money[i]; j < m + 1; j++){
                //만약 불가능한 금액이 아니라면
                if(dp[j - money[i]] != 10001){
                    //현재 dp의 값과 dp에서 화폐 단위를 뺀 인덱스의 값에 1을 더한 값과 비교하여 더 작은 값을 저장
                    dp[j] = Math.min(dp[j], dp[j - money[i]] + 1);
                }
            }
        }

        System.out.print(dp[m] != 10001 ? dp[m] : -1);
    }
}
