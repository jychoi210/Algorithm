package BFS.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_bfs2 {
    static int n,m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(reader.readLine());
            String temp = st.nextToken();
            for(int j = 0; j < m; j++){
                maze[i][j] = temp.charAt(j) - '0';
            }
        }

        BFS();
        System.out.println(maze[n - 1][m - 1]);

    }

    public static void BFS(){
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();

        qx.offer(0);
        qy.offer(0);

        visited[0][0] = true;

        while(!qx.isEmpty()){
            int x = qx.poll();
            int y = qy.poll();

            for(int t = 0; t < 4; t++){
                int nextX = x + dx[t];
                int nextY = y + dy[t];


                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m){
                    if(maze[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        qx.offer(nextX);
                        qy.offer(nextY);
                        visited[nextX][nextY] = true;
                        maze[nextX][nextY] = maze[x][y] + 1;
                    }
                }
            }
        }
    }
}