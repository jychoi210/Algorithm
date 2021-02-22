package BFS.DFS;

// 백준 DFS/BFS Q2606 바이러스
// https://www.acmicpc.net/problem/2606
// 바이러스 걸리는 컴퓨터 수 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2606 {
    public static int n, m, result = 0;
    // 방문 테이블
    public static boolean[] visited = new boolean[101];
    // 그래프 초기화
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void dfs(int x){
        // 현재 방문한 노드 true 설정
        visited[x] = true;
        // 개수 세기
        result++;
        // 현재 방문한 노드의 인접 노드에 대해 방문하지 않았다면 dfs수행
        for(int i = 0; i < graph.get(x).size(); i++){
            int t = graph.get(x).get(i);
            if(!visited[t]){
                dfs(t);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 컴퓨터 개수 n과 네트워크 연결 개수 m 입력 받기
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 0~n까지 그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }

        // 각 연결 정보 입력 받아 그래프에 저장
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // dfs 수행
        dfs(1);
        // result에서 1을 뺌(1에게 전염된 컴퓨터 수 이므로 1은 제외)
        System.out.print(result-1);
    }
}
