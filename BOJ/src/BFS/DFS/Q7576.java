package BFS.DFS;

// 백준 구현 Q7576 토마토
// https://www.acmicpc.net/problem/7576
// 토마토가 모두 익을 때까지 최소 날짜 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
    int x;
    int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Q7576 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Position> q = new ArrayDeque<>();

        int[] dx =  {1,0,-1,0};
        int[] dy =  {0,1,0,-1};

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m];

        // 박스 안의 토마토 정보 받기
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토는 큐에 삽입
                if(box[i][j] == 1){
                    q.offer(new Position(i,j));
                }
            }
        }

        int result = 0;

        while (!q.isEmpty()) {
            // 큐에서 새로운 위치 뽑아서 상하좌우 확인
            Position now = q.poll();
            for (int d = 0; d < 4; d++) {
                int mx = now.x + dx[d];
                int my = now.y + dy[d];
                if(mx >= 0 && mx < n && my >= 0 && my < m) {
                    //익지 않은 토마토라면
                    if (box[mx][my] == 0) {
                        // 현재 익은 토마토의 값에 1 더함
                        box[mx][my] = box[now.x][now.y] + 1;
                        q.offer(new Position(mx, my));
                    }
                }
            }
        }

        // 박스를 확인하여 익지 않은 토마토가 있으면 -1을 출력하고 종료
        // 그게 아니라면 제일 큰 값에서 1 빼줌 (익은 토마토가 1로 시작했으므로 1을 빼줌)
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
               if(box[i][j] == 0){
                   System.out.print(-1);
                   return;
               }
               result = Math.max(result, box[i][j]);
            }
        }
        System.out.print(result-1);
    }
}
