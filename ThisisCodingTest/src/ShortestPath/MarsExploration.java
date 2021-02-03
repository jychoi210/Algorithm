package ShortestPath;

// 이것이 코딩 테스트다.
// Chapter 17 : 최단 경로 기출 3 화성 탐사
// ACM-ICPC

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//화성 탐사 지점 정보(x좌표, y좌표, 비용)
class Road implements Comparable<Road>{
    int x;
    int y;
    int distance;

    public Road(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    //거리가 적은 것이 우선순위가 높도록 설정
    public int compareTo(Road other){
        return Integer.compare(this.distance, other.distance);
    }
}

public class MarsExploration {
    //테스트케이스 수, 탐사 공간
    public static int T, n;
    //무한의 수
    public static final int INF = (int)1e9;
    //탐사 공간 정보
    public static int[][] graph;
    //거리 정보
    public static int[][] d;
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};

    public static void main(String agrs[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트 케이스 입력 받기
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        //테스트 케이스 만큼 반복하기
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            graph = new int[n][n];

            //그래프 정보 입력 받기
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //거리 정보 담는 배열 INF로 초기화
            d = new int[n][n];
            Arrays.stream(d).forEach((int[] line) -> Arrays.fill(line,INF));

            //처음 시작은 0,0
            int x = 0, y = 0;
            PriorityQueue<Road> pq = new PriorityQueue<>();
            //큐에 담아줌
            pq.offer(new Road(0,0,graph[x][y]));
            d[x][y] = graph[x][y];

            while(!pq.isEmpty()){
                //거리가 가장 작은 것을 큐에서 꺼냄
                Road now = pq.poll();
                x = now.x;
                y = now.y;
                int dist = now.distance;
                //거리 테이블의 거리가 더 작으면 continue
                if(d[x][y] < dist) continue;
                //상하좌우 네 방향 검사
                for(int i = 0; i < 4; i++){
                    int mx = x + dx[i];
                    int my = y + dy[i];
                    //탐사 공간 안의 좌표일 때
                    if(mx >= 0 && mx < n && my >= 0 && my < n){
                        //거리 비교 후 담고 있던 값보다 작으면 작은 값으로 변경하고 큐에 삽입
                        int cost = dist + graph[mx][my];
                        if(cost < d[mx][my]){
                            d[mx][my] = cost;
                            pq.offer(new Road(mx, my, cost));
                        }
                    }
                }
            }
            sb.append(d[n-1][n-1]).append("\n");
        }

        System.out.print(sb.toString());
    }

}
