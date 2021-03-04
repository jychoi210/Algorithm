package BFS.DFS;

// 백준 DFS Q1012 유기농 배추
// https://www.acmicpc.net/problem/1012
// 인접한 배추 그룹의 개수 구하기 (DFS 버전)

import java.io.*;
import java.util.*;

public class Q1012_D {
    public static int m,n,k;
    public static int[][] map;
    public static boolean[][] visited;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
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

            for(int i = 0; i < k ; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

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

    public static void dfs(int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n) return;

        if(map[x][y] == 1){
            map[x][y] = -1;
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y-1);
            dfs(x,y+1);
        }
    }
}
