package Sorting;

// 이것이 코딩 테스트다.
// Chapter 14 : 정렬 기출 4 카드 정렬하기
// https://www.acmicpc.net/problem/1715

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortingCards {
    public static void main(String args[]) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n 입력 받기
        int n = Integer.parseInt(br.readLine());
        //n개의 카드 묶음 크기 입력 받기
        for(int i = 0; i < n; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int sum = 0;

        //pq.size가 2 이상일 때
        while (pq.size() != 1) {
            //카드 묶음 두개를 꺼내 합을 구한다.
            int a = pq.poll();
            int b = pq.poll();
            sum += a+b;
            //구한 합을 pq에 삽입
            pq.offer(a+b);
        }

        System.out.print(sum);
    }
}
