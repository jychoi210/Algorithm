package Sorting;

// 이것이 코딩 테스트다.
// Chapter 14 : 정렬 기출 2 안테나
// https://www.acmicpc.net/problem/18310

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Antenna {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //n 입력 받기
        int n = Integer.parseInt(st.nextToken());

        //집 위치기 정보 입력 받기
        int[] house = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            house[i] = Integer.parseInt(st.nextToken());
        }

        //정렬하기
        Arrays.sort(house);
        //홀수면 가운데 인덱스 출력
        if(n % 2 == 1) System.out.print(house[(house.length / 2)]);
        //짝수면 2개 중 앞에 것 출력
        else System.out.print(house[(house.length / 2 - 1)]);
    }
}
