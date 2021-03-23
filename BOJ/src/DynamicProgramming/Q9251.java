package DynamicProgramming;

// 백준 Dynamic Programming Q9251 LCS
// https://www.acmicpc.net/problem/9251
// 가장 긴 부분수열 구하기

//LCS 알고리즘
//비교하는 문자열이 같다면 대각선 위 + 1 -> 'ABC' 'BAC'인 경우 'AB' 'BA'의 LCS 값에 +1 해주는 것
//비교하는 문자열이 다르다면 왼쪽과 위쪽 중 큰 것 선택 -> 'ABC' 'CAB'인 경우 LCS('AB','CAB'), LCS('ABC','CA')중에 큰 것 선택

import java.io.*;
import java.util.*;

public class Q9251 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //문자열 두개 입력 받기
        String A = br.readLine();
        String B = br.readLine();

        //사이즈 저장
        int a = A.length();
        int b = B.length();

        //dp 테이블 만들기
        int[][] dp = new int[a+1][b+1];

        // dp 테이블 0으로 초기화
        for(int i = 0; i < a+1; i++){
            Arrays.fill(dp[i],0);
        }

        //1부터 a+1, b+1까지 반복
        for(int i = 1; i < a+1; i++){
            for(int j = 1; j < b+1; j++){
                //문자열이 같으면
                if(A.charAt(i-1) == B.charAt(j-1)){
                    //대각선 위 + 1
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    //문자열이 다르면 왼쪽과 위쪽 중 큰 것 선택
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.print(dp[a][b]);
    }
}
