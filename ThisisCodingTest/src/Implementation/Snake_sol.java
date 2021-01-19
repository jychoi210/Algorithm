package Implementation;

// 이것이 코딩 테스트다.
// Chapter 12 : 구현 기출 5 뱀 해답
// 삼성전자 SW 역량테스트
// https://www.acmicpc.net/problem/3190

//첫 시작 인덱스 0,0으로 설정하고 입력 받는 값에서 -1씩 해줌
// 길은 0, 뱀은 1, 사과는 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tail{
    int x;
    int y;

    public Tail(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }
}

public class Snake_sol {
    public static int n,k,l;
    public static int[][] board;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};
    public static int[][] direction = new int[l][2];

    public static int simulate(){
        int x = 0, y = 0;
        //뱀의 첫 위치 2로 설정
        board[x][y] = 2;
        int d = 3;
        int time = 0;
        int index = 0;
        Queue<Tail> q = new LinkedList<>();
        q.offer(new Tail(x,y));

        while(true){

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            int mx = x + dx[d];
            int my = y + dy[d];

            //이동할 값이 범위 안에 있고 뱀 자기 자신과 겹치지 않는다면
            if(0 <= mx && mx < n && 0 <= my && my < n && board[mx][my] != 2){
                if(board[mx][my] == 0){
                    board[mx][my] = 2;
                    q.offer(new Tail(mx, my));
                    //사과를 먹지 않았으므로 꼬리 부분을 0으로 바꿔줌
                    Tail t = q.poll();
                    board[t.getX()][t.getY()] = 0;
                }
                //사과라면
                if(board[mx][my] == 1){
                    //뱀의 길이를 늘리고 꼬리를 줄이지 않음
                    board[mx][my] = 2;
                    q.offer(new Tail(mx,my));
                }
            }
            //벽이나 뱀 자기 자신과 부딪혔다면
            else{
                time++;
                break;
            }
            //다음 위치로 이동
            x = mx;
            y = my;
            time++;

            if(index < l && time == direction[index][0]){
                //오른쪽 방향이면 오른쪽으로 방향 변환
                if (direction[index][1] == 1) {
                    d -= 1;
                    if (d < 0) d = 3;
                }
                //왼쪽 방향이면 왼쪽으로 방향 변환
                else {
                    d += 1;
                    if (d > 3) d = 0;
                }
                index++;
            }
        }
        return time;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        board = new int[n][n];
        // 사과 입력
        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        //방향 변환 정보 입력 받기
        l = Integer.parseInt(br.readLine());
        direction = new int[l][2];
        for(int i = 0; i < l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            direction[i][0] = Integer.parseInt(st.nextToken());
            if(st.nextToken().equals("L")) direction[i][1] = -1;
            else direction[i][1] = 1;
        }

        System.out.print(simulate());
    }
}
