package ShortestPath;

// 이것이 코딩 테스트다.
// Chapter 9 : 최단 경로 예제 2 다익스트라 알고리즘 2
// 우선순위 큐를 통해 시간 복잡도 줄임 : O(ElogV)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int index;
    int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    //거리가 짧은 것이 높은 우선 순위를 가지도록 설정
    @Override
    public int compareTo(Node o) {
        if(this.distance < o.distance) return -1;
        return 1;
    }
}
public class Dijkstra_PriorityQueue {
    //무한을 의미하는 10억 값 설정
    public static final int INF = (int) 1e9;
    //노드 개수 n, 간선 개수 m, 출발 노드 start
    public static int n, m, start;
    //최단 거리 테이블
    public static int[] dist = new int[100001];
    //그래프 정보를 담을 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //출발 노드 큐에 넣기
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        //큐가 빌 때 까지 반복
        while(!pq.isEmpty()){
            //큐에서 거리가 가장 짧은 노드 꺼냄
            Node node = pq.poll();
            //그 노드의 거리와 인덱스 저장
            int d = node.getDistance();
            int now = node.getIndex();
            //만약 노드의 거리보다 현재 인덱스의 거리 값이 작다면 continue
            if(dist[now] < d) continue;
            //now의 인접 노드들 확인
            for(int i = 0; i < graph.get(now).size(); i++){
                //cost는 출발노드에서 now노드까지의 최단 거리 + now에서 인접노드(get(i))까지의 거리
                int cost = dist[now] + graph.get(now).get(i).getDistance();
                //만약 출발 노드에서 인접노드(graph.get(now).get(i)까지의 거리가 cost보다 크다면
                //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < dist[graph.get(now).get(i).getIndex()]){
                    //최단 거리를 cost로 갱신
                    dist[graph.get(now).get(i).getIndex()] = cost;
                    //갱신된 값을 큐에 넣음
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //노드 개수, 간선 개수, 출발 노드 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        //그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Node>());
        }

        //그래프 정보 입력 받기, a에서 b노드의 거리가 c이다.
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b,c));
        }

        //거리 배열 무한대로 초기화
        Arrays.fill(dist, INF);

        //다익스트라 알고리즘 출력
        dijkstra(start);

        //최단 거리들 출력
        for(int i = 1; i <= n; i++){
            System.out.print(dist[i] == INF ? "INFINITY " : dist[i] + " ");
        }
    }
}
