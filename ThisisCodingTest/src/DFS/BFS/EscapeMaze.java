package DFS.BFS;

// 이것이 코딩 테스트다.
// Chapter 5 : DFS,BFS 문제 2 미로 탈출

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EscapeMaze {
    public static int maze[][];
    public static int n,m;
    public static boolean visited[][] = new boolean[200][200];
    public static int dx[] = {-1,0,1,0};
    public static int dy[] = {0,-1,0,1};

    public static void bfs(int startx, int starty){
        Queue<Integer> q = new LinkedList<>();

        q.offer(startx);
        q.offer(starty);

        visited[startx][starty] = true;

        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for(int d = 0; d < 4; d++) {
                int mx = x + dx[d];
                int my = y + dy[d];
                if (mx >= 0 && mx < n && my >= 0 && my < m) {
                    if (!visited[mx][my]) {
                        q.offer(mx);
                        q.offer(my);
                        visited[mx][my] = true;
                        maze[mx][my] = maze[x][y] + 1;
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for(int j = 0; j < m; j++){
                maze[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(maze[n-1][m-1]);
    }
}
