package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 18 : 그래프 이론 기출 5 최종 순위 해답
// https://www.acmicpc.net/problem/3665

// 위상정렬 이용
// 1. 진입차수가 0인 노드를 큐에 넣음
// 2. 큐가 빌 때 까지 다음의 과정을 반복
//  2.1 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거
//  2.2 새롭게 진입차수가 0이 된 노드를 큐에 넣음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FinalRanking_sol {
    public static int t, n, m;
    public static int[] indegree = new int[501];
    public static boolean[][] graph = new boolean[501][501];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < t; tc++){
            n = Integer.parseInt(br.readLine());
            Arrays.fill(indegree, 0);
            for(int i = 0; i < 501; i++){
                Arrays.fill(graph[i], false);
            }

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    graph[arr[i]][arr[j]] = true;
                    indegree[arr[j]] += 1;
                }
            }

            m = Integer.parseInt(br.readLine());

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(graph[a][b]){
                    graph[a][b] = false;
                    graph[b][a] = true;
                    indegree[a] += 1;
                    indegree[b] -= 1;
                }else{
                    graph[a][b] = true;
                    graph[b][a] = false;
                    indegree[a] -= 1;
                    indegree[b] += 1;
                }
            }

            ArrayList<Integer> result = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();

            for(int i = 1; i <= arr.length; i++){
                if(indegree[i] == 0) q.offer(i);
            }

            boolean certain = true;
            boolean cycle = false;

            for(int i = 0; i < n; i++){
                if(q.size() == 0){
                    cycle = true;
                    break;
                }
                if(q.size() >= 2){
                    certain = false;
                    break;
                }
                int now = q.poll();
                result.add(now);

                for(int j = 1; j <= n; j++){
                    if(graph[now][j]){
                        indegree[j] -= 1;
                        if(indegree[j] == 0) q.offer(j);
                    }
                }
            }

            if(cycle) sb.append("IMPOSSIBLE").append("\n");
            else if(!certain) sb.append("?").append("\n");
            else{
                for(int i = 0; i < n; i++){
                    sb.append(result.get(i)).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
