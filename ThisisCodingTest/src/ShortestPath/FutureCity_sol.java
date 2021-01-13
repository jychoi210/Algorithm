package ShortestPath;

// 이것이 코딩 테스트다.
// Chapter 9 : 최단 경로 문제 1 미래 도시 해답
// 1 -> k -> x의 최단 거리
// 시작점이 한개가 아니며, 주어진 노드의 개수가 크지 않으므로 플로이드 워셜로 풀이 가능

import java.util.Arrays;
import java.util.Scanner;

public class FutureCity_sol {
    public static int n,m,x,k;
    public static final int INF = (int) 1e9;
    public static int[][] graph = new int[101][101];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        //그래프 초기화
        for(int i = 0; i < 101; i++){
            Arrays.fill(graph[i], INF);
        }

        //자기 자신까지의 거리는 0으로 초기화
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                if(i==j) graph[i][j] = 0;
            }
        }

        //입력 받은 정보 삽입
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        //x,k 입력 받기
        x = sc.nextInt();
        k = sc.nextInt();

        //점화식을 사용하여 a->b의 거리와 a->k->b의 거리 중 작은 것을 선택하여 저장
        for(int k = 1; k <=n; k++){
            for(int a = 1; a<=n ; a++){
                for(int b = 1; b <= n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        //1에서 k의 최단 거리와 k에서 x의 최단 거리 더함
        int answer = graph[1][k] + graph[k][x];

        System.out.print(answer >= INF ? -1 : answer);



    }
}
