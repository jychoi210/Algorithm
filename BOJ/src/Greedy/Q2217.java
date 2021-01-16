package Greedy;

// 백준 그리디 Q2217 로프
// https://www.acmicpc.net/problem/5585
// 1000엔을 낸 후 받을 거스름 돈의 최소 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2217 {
    public static void main(String agrs[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //로프 개수 입력 받기
        int[] rope = new int[n];

        //로프 중량 입력 받기
        for(int i = 0; i < n; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }

        //로프 정렬 하기
        Arrays.sort(rope);
        int max = 0;

        //어떤 로프를 기준 삼아 최대값을 정할지 비교
        for(int i = 0; i < n; i++){
            if(rope[i] * (n-i) > max) max = rope[i] * (n-i);
        }

        System.out.print(max);
    }
}
