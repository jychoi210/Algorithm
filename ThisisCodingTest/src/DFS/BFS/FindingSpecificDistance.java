package DFS.BFS;

// 이것이 코딩 테스트다.
// Chapter 12 : DFS, BFS 기출 1 특정 거리의 도시 찾기
// https://www.acmicpc.net/problem/18352

//다익스트라 버전

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindingSpecificDistance {
    //무한을 의미하는 10억 값 설정
    public static final int INF = (int) 1e9;
    //노드 개수 n, 간선 개수 m, 특정 거리 k, 시작 도시 x
    public static int n,m,k,x;
    //최단 거리 테이블
    public static int[] dist = new int[300001];
    //그래프 정보를 담을 배열
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void findCity(int start){
        //q에 처음 도시 입력
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while(!q.isEmpty()){
            //큐에서 도시 번호 꺼냄
            int now = q.poll();
            //그 도시와 인접한 노드들의 최단 거리 구하기
            for(int i = 0; i < graph.get(now).size(); i++){
                //현재 거리에 + 1 한 것과 인접한 노드의 현재 최단 거리 비교
                //d[2] + 1과 d[3] 비교
                //2를 거쳐 3으로 가는 것과 이전의 3까지의 거리 중 작은것 선택
                //완료 되면 q에 넣기
                int cost = dist[now] + 1;
                if(cost < dist[graph.get(now).get(i)]){
                    dist[graph.get(now).get(i)] = cost;
                    q.offer(graph.get(now).get(i));
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //n, m, k, x 입력 받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        //그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }

        //그래프 정보 입력 받기
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        // dist 배열 INF로 초기화
        Arrays.fill(dist, INF);
        //최단 거리 찾기
        findCity(x);

        //최단거리가 k면 도시의 번호 출력
        boolean flag = false;
        for(int i = 1; i < n + 1; i++){
            if(dist[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }

        //최단거리가 k인 도시가 하나도 없다면 -1출력
        if(!flag) System.out.print(-1);
    }
}
