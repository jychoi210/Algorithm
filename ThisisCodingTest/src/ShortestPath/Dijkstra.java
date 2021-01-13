package ShortestPath;

// 이것이 코딩 테스트다.
// Chapter 9 : 최단 경로 예제 1 다익스트라 알고리즘 1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node1{
    int index;
    int distance;

    public Node1(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return index;
    }

    public int getDistance() {
        return distance;
    }
}

public class Dijkstra {
    public static final int INF = (int) 1e9;
    //노드 개수 n, 간선 개수 m, 시작 노드 start
    public static int n,m,start;
    public static ArrayList<ArrayList<Node1>> graph = new ArrayList<ArrayList<Node1>>();
    //입력받을 수 있는 최대 노드 개수는 100,000개라고 가정
    public static boolean[] visited = new boolean[100001];
    public static int[] dist = new int[100001];

    public static void dijkstra(int start){
        //시작 노드 초기화
        dist[start] = 0;
        visited[start] = true;
        //start에 인접한 노드들의 간선으로 거리 값(dist) 업데이트
        for(int j = 0; j < graph.get(start).size(); j++){
            dist[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }
        //시작 노드 제외한 n-1개 노드에 대해 반복
        for(int i = 0; i < n - 1; i++){
            //현재 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리
            int now = getSmallestNode();
            visited[now] = true;
            //현재 노드와 연결된 다른 노드들 확인
            for(int j = 0; j < graph.get(now).size(); j++){
                //현재 노드의 값 + 현재 노드에서 j노드까지의 거리를 cost에 저장
                int cost = dist[now] + graph.get(now).get(j).getDistance();
                //만약 cost가 현재 j 노드의 거리 값보다 작으면
                if(cost < dist[graph.get(now).get(j).getIndex()]){
                    //j 노드의 거리 값을 cost로 갱신
                    dist[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    //방문하지 않은 노드들 중, 최단 거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode(){
        int minValue = INF;
        int index = 0;
        //1 부터 n까지 반복
        for(int i = 1; i <= n; i++){
            //minValue보다 최단거리가 짧고 방문하지 않았다면 데이터 갱신
            if(dist[i] < minValue && !visited[i]){
                minValue = dist[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //노드 개수 입력 받기
        n = sc.nextInt();
        //간선 개수 입력 받기
        m = sc.nextInt();
        //출발 노드 입력 받기
        start = sc.nextInt();

        //그래프 초기화 필수
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Node1>());
        }

        for(int i = 0; i < m; i++){
            //시작 노드
            int a = sc.nextInt();
            //도착 노드
            int b = sc.nextInt();
            //간선 비용
            int c = sc.nextInt();
            //a에서 b노드로 가는 비용이 c인 데이터 graph에 입력
            graph.get(a).add(new Node1(b,c));
        }

        //dist배열 모두 INF로 채워주기
        Arrays.fill(dist, INF);

        //다익스트라 알고리즘 실행
        dijkstra(start);

        //각 노드까지의 최단 거리 출력 단, 무한이면 "INFINITY"출력
        for(int i = 1; i <=n; i++){
            System.out.print(dist[i] == INF ? "INFINITY " : dist[i] + " ");
        }
    }
}
