package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 16 : 다이나믹 프로그래밍 기출 1 금광 해답
// Flipkart Interview
// 다이나믹 프로그래밍 해법

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoldMine_sol {
    public static int n, m;
    public static int[][] gold = new int[20][20];
    public static int[][] dp = new int[20][20];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i  = 0; i < n; i++){
                for(int j = 1; j <= m; j++){
                    gold[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = gold[i][j];
                }
            }

            for(int j = 1; j < m; j++){
                for(int i = 0; i < n; i++){
                    int leftup, leftdown, left;
                    //왼쪽 위에서 오는 경우
                    if(i == 0) leftup = 0;
                    else leftup = dp[i - 1][j - 1];
                    //왼쪽 아래에서 오는 경우
                    if(i == n-1) leftdown = 0;
                    else leftdown = dp[i + 1][j - 1];
                    //왼쪽에서 오는 경우
                    left = dp[i][j - 1];
                    dp[i][j] = dp[i][j] + Math.max(leftup, Math.max(leftdown,left));
                }
            }
            int result = 0;
            for(int i = 0; i < n; i++){
                result = Math.max(result, dp[i][m-1]);
            }
            System.out.println(result);
        }
    }
}
