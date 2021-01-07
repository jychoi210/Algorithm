package Implementation;

// 이것이 코딩 테스트다.
// 구현 04-3 게임 개발

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GameDevelopment {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static int n, m;
    static int cnt = 0;
    static int result = 1;

    //방향 회전 함수
    public static int rotate(int d){
        d = d -1;
        if(d < 0) d = 3;
        return d;
    }

    public static void move(int x, int y, int d){

        //현재 위치의 왼쪽 좌표
        int mx = x + dx[d];
        int my = y + dy[d];

        //현재 위치의 왼쪽 좌표가 map을 벗어나지 않을 경우
        if (mx >= 0 && mx < n && my >= 0 && my < m) {

            //만약 상하좌우 모두 회전했지만 방문할 곳이 없는 경우
            if (cnt == 4) {
                x = x + dx[d] * (-1);
                y = y + dy[d] * (-1);
                if (map[x][y] != 0) return;
                move(x, y, d);
            }

            //왼쪽 좌표가 방문하지 않은 땅이라면 왼쪽으로 이동하여 방문
            if (map[mx][my] == 0) {
                result++;
                cnt = 0;
                x = mx;
                y = my;
                map[mx][my] = 2;
                move(x,y,d);
            }
            //왼쪽 방향에 가보지 않은 칸이 없는 경우 왼쪽 방향으로 회전
            else {
                d = rotate(d);
                cnt++;
                move(x, y, d);
            }
        }
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];


        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String[] row = br.readLine().split(" ");
            int[] col = Arrays.stream(row).mapToInt(Integer::parseInt).toArray();
            map[i] = col;
        }

        //현재 땅을 방문한 것으로 간주하여 2로 변환(방문한 땅은 2)
        map[x][y] = 2;
        move(x,y,d);

        System.out.print(result);


    }
}
