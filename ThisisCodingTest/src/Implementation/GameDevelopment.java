package Implementation;

// 이것이 코딩 테스트다.
// 구현 04-3 게임 개발

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GameDevelopment {
    static int[] direction = {0, 1, 2, 3};
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static int n, m;
    static int cnt = 0;
    static int result = 1;

    public static int rotate(int d){
        d = d -1;
        if(d < 0) d = 3;
        return d;
    }

    public static void move(int x, int y, int d){
        int index = 0;
        //System.out.println("x : " + x + " y : " + y);
        for(int i = 0; i <4; i++) {
            if (direction[i] == d) {
                index = i;
            }
        }
        //현재 위치의 왼쪽 좌표
        int mx = x + dx[index];
        int my = y + dy[index];

        //map을 벗어나지 않는다면,
        if (mx >= 0 && mx < n && my >= 0 && my < m) {
            //만약 상하좌우 모두 회전한 경우
            if (cnt == 4) {
                x = x + dx[index] * (-1);
                y = y + dy[index] * (-1);
                if (map[x][y] != 0) return;
                move(x, y, d);
            }
            //System.out.println("mx : " + mx + " my : " + my + " map[mx][my] : " + map[mx][my] + " rotate : " + d);
            //왼쪽 좌표가 방문하지 않은 땅이라면
            if (map[mx][my] == 0) {
                result++;
                cnt = 0;
                x = mx;
                y = my;
                map[mx][my] = 2;
                //System.out.println("왼쪽에 방문하지 않은 땅이 있으므로 방문한다.");
                move(x,y,d);
            } else {
                d = rotate(d);
                //System.out.println("왼쪽에 방문하지않은 땅이 없으므로 회전한다.");
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

        map[x][y] = 2;
        move(x,y,d);

        System.out.print(result);


    }
}
