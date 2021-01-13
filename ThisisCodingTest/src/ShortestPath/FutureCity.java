package ShortestPath;

// 이것이 코딩 테스트다.
// Chapter 9 : 최단 경로 문제 1 미래 도시
// 1 -> k -> x의 최단 거리

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//회사 클래스 구현
class Company implements Comparable<Company>{
    int index;
    int distance;

    public Company(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    //작은 수가 우선 순위가 높도록 설정
    @Override
    public int compareTo(Company o){
        if(this.distance < o.distance) return -1;
        return 1;
    }
}

public class FutureCity {
    //회사 개수, 경로 개수, 출발 위치
    public static final int INF = (int) 1e9;
    //회사 개수, 경로 개수, x번 회사, k번 회사
    public static int n, m, x, k;
    //그래프 정보 담을 arraylist
    public static ArrayList<ArrayList<Company>> graph = new ArrayList<ArrayList<Company>>();
    //최단 거리 테이블
    public static int[] d = new int[101];

    public static void dijkstra(int start){
        PriorityQueue<Company> pq = new PriorityQueue<>();
        //시작 회사 큐에 넣음
        pq.offer(new Company(start, 0));
        //start의 거리는 0으로 설정
        d[start] = 0;
        //큐가 빌 때 까지 반복
        while(!pq.isEmpty()){
            //우선 순위가 높은(거리가 가장 짧은) 회사 하나 뽑음
            Company c = pq.poll();
            //그 노드의 인덱스 저장
            int now = c.getIndex();
            //그 노드까지의 거리 저장
            int dist = c.getDistance();
            //현재 노드가 이미 처리된 노드라면
            if(d[now] < dist) continue;
            //인접 노드들 확인
            for(int i = 0; i < graph.get(now).size(); i++){
                //현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if(cost < d[graph.get(now).get(i).getIndex()]){
                    //값을 갱신하고 큐에 넣음
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Company(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        //그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Company>());
        }

        Arrays.fill(d,INF);

        //회사와 경로 수 입력 받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(new Company(b,1));
            graph.get(b).add(new Company(a,1));
        }

        x = sc.nextInt();
        k = sc.nextInt();

        //1에서 k로 가는 거리 구하고
        dijkstra(1);
        int answer = d[k];

        //d를 초기화 한 후
        Arrays.fill(d,INF);

        //k에서 x로 가는 거리 구한다.
        dijkstra(k);
        answer += d[x];

        //만약 가는 길이 없어서 answer가 무한대(INF)보다 크다면 -1을, 아니면 answer값을 출력
        System.out.print(answer >= INF ? -1 : answer);

    }
}
