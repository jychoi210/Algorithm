
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


 /*
import java.io.*;
import java.util.*;

public class bj_bfs2 {
    static int n, m;
    static int[] dx = {0, 1, 0, -1}; //상우하좌
    static int[] dy = {1, 0, -1, 0};
    static int[][] maze; //미로
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new int[n][m];
        checked = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String temp = sc.next(); //붙어서 입력되기 때문에 다음 공백까지 받아오는 .next() 사용
            for(int j = 0; j < m; j++) {
                maze[i][j] = (int)temp.charAt(j) - 48; //아스키코드값 변환
            }
        }
        bfs();
        System.out.print(maze[n - 1][m - 1]); //(N, M) 출력. 좌표값이기 때문에 -1
    }

    public static void bfs() {
        Queue<Integer> queue_x = new LinkedList<Integer>(); //x값에 대한 Queue
        Queue<Integer> queue_y = new LinkedList<Integer>(); //y값에 대한 Queue

        queue_x.offer(0); //저장
        queue_y.offer(0);

        checked[0][0] = true;

        while(!queue_x.isEmpty()) {
            int x = queue_x.poll();
            int y = queue_y.poll();

            //상하좌우 확인
            for(int k = 0; k < 4;k++) {
                int temp_x = x + dx[k];
                int temp_y = y + dy[k];

                //유효한 범위인지 확인
                if(temp_x >= 0 && temp_y >= 0 && temp_x < n && temp_y < m) {
                    if(maze[temp_x][temp_y] == 1 && checked[temp_x][temp_y] == false) {
                        queue_x.offer(temp_x);
                        queue_y.offer(temp_y);

                        checked[temp_x][temp_y] = true;

                        maze[temp_x][temp_y] = maze[x][y] + 1; //이동횟수
                    }
                }
            }
        }
    }
}
*/
