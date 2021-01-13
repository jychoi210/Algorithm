package ShortestPath;

// 이것이 코딩 테스트다.
// Chapter 9 : 최단 경로 문제 2 전보
// C에서 출발하여 도달할 수 있는 모든 노드의 개수와 그 중 가장 긴 거리(시간) 구하기

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class City implements Comparable<City>{
    int index;
    int distance;

    public City(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(City o){
        if(this.distance < o.distance) return -1;
        return 1;
    }
}

public class Telegram {
    public static final int INF = (int) 1e9;
    public static int n, m, c;
    public static ArrayList<ArrayList<City>> graph = new ArrayList<ArrayList<City>>();
    public static int d[] = new int[30001];

    public static void dijkstra(int start){
        PriorityQueue<City> pq = new PriorityQueue<>();
        //시작 도시 큐에 넣음
        pq.offer(new City(start, 0));
        //시작 노드의 거리 0으로 설정
        d[start] = 0;
        //큐가 빌 때 까지 반복
        while(!pq.isEmpty()){
            //우선순위가 가장 높은 도시(시간 가장 적게 걸리는 도시) 꺼냄
            City c = pq.poll();
            int now = c.getIndex();
            int dist = c.getDistance();
            //이미 방문 처리 되었다면 continue
            if(d[now] < dist) continue;
            //현재 도시에 인접한 도시들부터 탐색
            for(int i = 0; i < graph.get(now).size(); i++){
                //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new City(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        //그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        //최단 거리 리스트 초기화
        Arrays.fill(d,INF);

        //도시와 전달 시간 정보 입력
        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.get(x).add(new City(y,z));
        }

        //c에서 시작하는 최단 거리 구하기
        dijkstra(c);

        int max = 0;
        int cnt = 0;

        for(int i = 1; i <= n; i++){
            //무한대가 아닌 값은 도달할 수 있으므로 cnt++
            if(d[i] < INF) cnt++;
            //시간(거리)이 가장 긴 도시 구하기
            if(d[i] > max) max = d[i];
        }

        //시작 노드 제외
        cnt -= 1;

        System.out.print(cnt + " " + max);
    }
}
