package BFS.DFS;

// 백준 DFS Q1012 유기농 배추
// https://www.acmicpc.net/problem/1012
// 인접한 배추 그룹의 개수 구하기 (DFS 버전)

import java.io.*;
import java.util.*;

public class Q1012_D {
    // m x n 값과 배추 개수 k
    public static int m,n,k;
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // test 케이스 입력 받기
        int test = Integer.parseInt(br.readLine());
        int x, y;

        for(int t = 0; t < test; t++){
            int result = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            visited = new boolean[m][n];

            // 배추 k개의 정보 입력 받기
            for(int i = 0; i < k ; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            // 밭에서 방문 안한 배추 위치를 방문하여 true로 바꾼 후, dfs()호출
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        visited[i][j] = true;
                        dfs(i,j);
                        result++;
                    }
                }
            }

            sb.append(result).append("\n");
        }
        System.out.print(sb.toString());
    }

    // dfs 함수
    public static void dfs(int x, int y){
        // x, y가 밭 범위를 벗어났다면 return
        if(x < 0 || x >= m || y < 0 || y >= n) return;

        // 배추 위치라면, -1로 변경(방문 표시)
        // 상하좌우에 대해 다시 dfs 호출
        if(map[x][y] == 1){
            map[x][y] = -1;
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y-1);
            dfs(x,y+1);
        }
    }
}
