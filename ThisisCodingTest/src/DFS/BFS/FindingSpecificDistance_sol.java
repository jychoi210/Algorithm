package DFS.BFS;

// 이것이 코딩 테스트다.
// Chapter 12 : DFS, BFS 기출 1 특정 거리의 도시 찾기 해답
// https://www.acmicpc.net/problem/18352

//BFS 버전
//시간 훨씬 빠름

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindingSpecificDistance_sol {
    //노드 개수 n, 간선 개수 m, 특정 거리 k, 시작 도시 x
    public static int n,m,k,x;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static int[] d = new int[300001];

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
            d[i] = -1;
        }
        //그래프 정보 입력 받기
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        //시작 노드의 최단 거리 0으로 설정
        d[x] = 0;

        //q에 x 넣기
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while(!q.isEmpty()){
            //q에서 도시 번호 꺼낸 후 인접한 도시들 확인
            int now = q.poll();
            for(int i = 0; i < graph.get(now).size(); i++){
                int next = graph.get(now).get(i);
                //만약 -1이면, 즉 초기화 된 상태면 1 더해주기
                if(d[next] == -1){
                    d[next] = d[now] + 1;
                    q.offer(next);
                }
            }
        }

        boolean flag = false;
        //최단 거리가 k인 도시의 번호 출력
        for(int i = 1; i < n + 1; i++){
            if(d[i] == k){
                System.out.println(i);
                flag = true;
            }
        }

        //최단 거리가 k인 도시가 없다면 -1 출력
        if(!flag) System.out.print(-1);
    }
}
