package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 16 : 다이나믹 프로그래밍 기출 5 못생긴 수
// Google Interview

import java.util.PriorityQueue;
import java.util.Scanner;

public class UglyNumber {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //작은 순서대로 넣기 위해 우선순위 큐 사용
        PriorityQueue<Integer> q = new PriorityQueue<>();
        //못생긴 수를 담을 배열
        int[] dp = new int[n];

        int index = 0;
        q.offer(1);
        //n개가 담기면 종료
        while(index < n){
            //가장 작은 수를 빼서 못생긴 수에 넣음
            int now = q.poll();
            dp[index] = now;
            //그 수에 2,3,5를 곱한 수를 큐에 다시 삽입
            if(!q.contains(now * 2)) {
                q.offer(now * 2);
            }
            if(!q.contains(now * 3)) {
                q.offer(now * 3);
            }
            if(!q.contains(now * 5)) {
                q.offer(now * 5);
            }
            index++;
        }
        for(int i : dp) {
            System.out.print(i + " ");
        }
    }
}
