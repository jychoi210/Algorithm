package ShortestPath;

// 이것이 코딩 테스트다.
// Chapter 17 : 최단 경로 기출 4 숨바꼭질
// USACO

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class HideNSeek {
    public static int n, m;
    public static final int INF = (int)1e9;
    public static int[] d;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String agrs[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //헛간 개수 n개
        n = Integer.parseInt(st.nextToken());
        //M개의 양방향 통로
        m = Integer.parseInt(st.nextToken());

        //graph 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }

        //M개의 통로 정보 입력 받기
        //양방향 이므로 바꿔서도 입력해줌
        for(int i  = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //0~n까지 거리를 담을 배열
        d = new int[n+1];
        //무한으로 초기화 함
        Arrays.fill(d,INF);
        //우선순위 큐 만들기
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //우선순위 큐에 시작점 1을 넣음
        pq.offer(1);
        d[1] = 0;

        while(!pq.isEmpty()){
            int now = pq.poll();
            //현재 선택된 헛간과 연결되어 있는 헛간들 비교
            for(int i =0 ; i < graph.get(now).size(); i++){
                //만약 현재 저장되어 있는 거리가 선택된 헛간 + 1보다 크다면
                if(d[graph.get(now).get(i)] > d[now] + 1){
                    //거리를 작은 것으로 갱신
                    d[graph.get(now).get(i)] = d[now] + 1;
                    //큐에 넣기
                    pq.offer(graph.get(now).get(i));
                }
            }
        }

        //헛간번호 result, 그 헛간까지의 거리 distance, 같은 거리의 헛간들의 수 num
        int result = n+1, distance = 0, num = 0;
        //최단 거리가 가장 먼 헛간의 거리 구하기
        for(int i = 1; i <= n; i++){
            distance = Math.max(distance, d[i]);
        }
        //최단 거리가 가장 멋 헛간 중 가장 작은 헛간 번호 구하기
        //최단 거리가 가장 먼 헛간과 같은 거리를 가진 헛간들의 수 구하기
        for(int i = 1; i <= n; i++){
            if(d[i] == distance){
                result = Math.min(result, i);
                num++;
            }
        }

        System.out.print(result+" "+distance+" "+num);
    }
}
