package ShortestPath;

// 이것이 코딩 테스트다.
// Chapter 9 : 최단 경로 예제 3 플로이드 워셜 알고리즘
// 시간 복잡도 : O(N^3) -> 노드의 개수가 적을 때 사용

import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {
    public static final int INF = (int) 1e9;
    //노드 개수, 간선 개수
    public static int n, m;
    //최대 노드 개수는 500개라고 가정
    public static int[][] graph = new int[501][501];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        //그래프 초기화
        for(int i = 0; i < 501; i++){
            Arrays.fill(graph[i], INF);
        }

        //자신에서 자기 자신으로 가는 비용은 0으로 초기화  (a -> a)
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                if(i == j) graph[i][j] = 0;
            }
        }

        //각 간선에 대한 정보를 입력 받아 그 값으로 초기화
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        //플로이도 워셜 점화식 사용하여 최단 거리 테이블 갱신
        //a->b 비용과 a->k->b비용 비교하여 더 작은 것으로 저장
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <=n; a++){
                for(int b = 1; b <= n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                System.out.print(graph[i][j] == INF ? "INFINITY " : graph[i][j]+ " ");
            }
            System.out.println();
        }

    }
}
