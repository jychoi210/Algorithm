package Greedy;

// 백준 그리디 Q2839 설탕 배달
// https://www.acmicpc.net/problem/2839

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2839 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //설탕 n 입력받기
        int n = Integer.parseInt(br.readLine());
        //봉지 개수를 담을 변수
        int result = 0;

        //n > 0이면 반복
        while (n > 0) {
            //5로 나누어 지면 5를 뺴고 result++
            if(n % 5 == 0){
                n -= 5;
            }
            //5로 나누어 지지 않으면 3을 빼고 result++
            else {
                n-= 3;
            }
            result++;
        }

        // 딱 나누어 떨어져 n = 0이라면 result, 0이 아니라면 -1 출력
        System.out.print(n == 0 ?  result : -1);
    }
}
