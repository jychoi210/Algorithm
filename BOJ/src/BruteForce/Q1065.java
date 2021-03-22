package BruteForce;

// 백준 브루트포스 Q1065 한수
// https://www.acmicpc.net/problem/1065
// 각 자리의 수가 등차수열인 수의 개수 구하기

import java.io.*;

public class Q1065 {
    public static int answer = 99;
    public static int[] num = new int[3];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // X 입력 받기
        int X = Integer.parseInt(br.readLine());

        // X가 100보다 작으면 자기 자신 출력
        if(X < 100){
            System.out.print(X);
        }else{
            // X가 1000이면 999로 설정(1000은 한수가 아님)
            if(X == 1000){
                X = 999;
            }
            //100부터 X까지 반복하여 한수 찾기
            for(int n = 100; n <= X; n++){
                //백의 자리
                num[0] = n / 100;
                //십의 자리
                num[1] = (n / 10) % 10;
                //일의 자리
                num[2] = n % 10;
                //백의 자리 - 십의 자리 = 십의 자리 - 일의 자리 라면 count
                if((num[2]-num[1]) == (num[1]-num[0])) {
                    answer++;
                }
            }
            System.out.print(answer);
        }
    }
}
