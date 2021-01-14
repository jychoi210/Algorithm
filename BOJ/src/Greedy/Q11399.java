package Greedy;

// 백준 그리디 Q11399 ATM
// https://www.acmicpc.net/problem/11399

import java.util.Arrays;
import java.util.Scanner;

public class Q11399 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[n];

        //돈을 인출하는 데 걸리는 시간 입력 받기
        for(int i = 0; i < n; i++){
            time[i] = sc.nextInt();
        }

        //인출 시간 순서로 정렬
        Arrays.sort(time);

        //필요한 시간을 담을 변수
        int result = 0;

        //time[0] * n + time[1] * (n-1) ... 더해서 값 구하기
        for(int i = n; i > 0; i--){
            result += i * time[n-i];
        }

        System.out.println(result);

        /*
        // 피보나치 배열로 값 구하기
        // 각 사람들의 대기 시간을 담을 배열
        // int[] result2 = new int[n];
        // int sum = 0;

        result2[0] = time[0];
        for(int i = 1; i < n; i++){
            result2[i] = result2[i - 1] + time[i];
        }

        for(int i = 0; i < n; i++){
            sum += result2[i];
        }

        //System.out.print(sum);
         */


    }
}
