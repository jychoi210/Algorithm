package ShortestPath;

// 이것이 코딩 테스트다.
// Chapter 17 : 최단 경로 기출 1 플로이드
// https://www.acmicpc.net/problem/11404

// 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다는 점을 잘 생각해야 함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyd {
    public static final int INF = (int)1e9;
    //도시 개수와 버스 개수
    public static int n, m;
    //노선 정보 입력할 그래프
    public static int[][] graph = new int[101][101];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //도시 개수 입력 받기
        n = Integer.parseInt(br.readLine());
        //버스 개수 입력 받기
        m = Integer.parseInt(br.readLine());

        /*
        for(int i  = 0; i < 101; i++){
            Arrays.fill(graph[i], INF);
        }
        */

        //graph[][]를 INF로 초기화 하기
        Arrays.stream(graph).forEach((int[] line) -> Arrays.fill(line, INF));

        //i->i로 가는 길은 0으로 초기화(자기 자신으로 가는 길)
        for(int i  = 1; i <= n; i++){
            for(int j  = 1; j <= n; j++){
                if(i==j) graph[i][j] = 0;
            }
        }

        //노선(출발 도시, 도착 도시, 비용) 정보 입력 받기
        for(int i  = 0 ; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            //노선이 하나가 아닐 수 있으므로 최소 값을 입력 받기
            if(graph[a][b] > c) graph[a][b] = c;
        }

        //플로이드 워셜 알고리즘 사용
        //a->b 비용과 a->k->b 비용 비교하여 최소 비용 구하기
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <=n; b++){
                    graph[a][b] = Math.min(graph[a][b] , graph[a][k] + graph[k][b]);
                }
            }
        }

        //갈 수 없는 경우(경로가 없는 경우) 0으로 바꿔 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sb.append(graph[i][j] == INF ? 0 : graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
