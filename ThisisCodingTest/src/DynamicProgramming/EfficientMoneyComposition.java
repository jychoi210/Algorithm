package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 8 : 다이나믹 프로그래밍 문제 4 효율적인 화폐 구성

import java.util.Scanner;

public class EfficientMoneyComposition {
    public static int[] dp = new int[10001];

    public static int moneyComposition(int[] money, int m){
        for(int i = 0; i < m; i++){
            boolean flag = false;
            for(int j = 0; j < money.length; j++){
                if(m % money[j] == 0) {
                    dp[i] = m / money[j];
                    flag = true;
                }
            }
            if(!flag) return -1;
        }
        return dp[m -1];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] money = new int[n];
        for(int i = 0; i < n; i++){
            money[i] = sc.nextInt();
        }

        System.out.print(moneyComposition(money, m));
    }
}
