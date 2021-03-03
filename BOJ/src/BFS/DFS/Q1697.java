package BFS.DFS;

// 백준 BFS Q1697 숨바꼭질
// https://www.acmicpc.net/problem/1697
// 현재 위치에서 동생의 위치까지 도달하는 데 가장 빠른 시간

import java.io.*;
import java.util.*;

public class Q1697 {
    // 현재 위치 n, 동생 위치 k
    public static int n, k;
    public static int[] map = new int[100001];

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n, k 입력 받기
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 만약 현재 n의 위치가 k라면 0 출력
        if(n==k) {
            System.out.print(0);
        }
        // 아니라면 BFS() 호출
        else {
            BFS();
        }
    }

    public static void BFS(){
        Queue<Integer> q = new LinkedList<Integer>();
        // 처음 위치 큐에 삽입
        q.offer(n);
        // 해당 위치 1로 설정
        map[n] = 1;
        while(!q.isEmpty()){
            // 현재 위치 큐에서 뽑음
            int now = q.poll();

            // 3가지 경우에 대해 next 값 구하기
            for(int i = 0; i < 3; i++){
                int next;
                if(i==0){
                    next = now - 1;
                }else if(i==1){
                    next = now + 1;
                }else{
                    next = now * 2;
                }

                // next가 k와 같다면 map[now]를 출력(현재까지의 초)
                if(next == k){
                    System.out.print(map[now]);
                    return;
                }

                // next가 0<= x <= 100000 범위이고, map[next]가 0이라면
                if(next >= 0 && next <= 100000 && map[next] == 0){
                    // next를 큐에 넣음
                    q.offer(next);
                    // map[now]의 값에 1 더해 map[next]에 저장
                    map[next] = map[now] + 1;
                }
            }

        }

    }
}
