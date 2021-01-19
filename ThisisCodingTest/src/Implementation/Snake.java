package Implementation;

// 이것이 코딩 테스트다.
// Chapter 12 : 구현 기출 5 뱀
// 삼성전자 SW 역량테스트
// https://www.acmicpc.net/problem/3190

// 꼬리를 어떻게 제거할 지가 관건
// 처음에는 좌표 값으로 꼬리를 제거하여 어려움이 있었으나, queue를 사용하여 해결할 수 있었음
// 0은 벽 1은 길 2는 사과 3은 뱀이 가는 길로 설정함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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

public class Snake {
    //동서남북 좌표
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};

    public static void main(String args[]) throws IOException {
        //각 꼬리를 차례대로 저장할 큐
        Queue<Position> q = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n 입력 받기
        int n = Integer.parseInt(br.readLine());

        //n+2 x n+2 배열을 만들어 주위를 벽을 의미하는 0으로 설정
        int[][] board = new int[n+2][n+2];

        // n x n 정사각형에 길을 의미하는 1로 채움
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                board[i][j] = 1;
            }
        }

        //사과 개수 입력 받기
        int k = Integer.parseInt(br.readLine());

        //사과 위치 입력 받아서 2로 설정
        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
        }

        //방향 변환 횟수 입력 받기
        int l = Integer.parseInt(br.readLine());
        //방향 변환할 시간
        int[] second = new int[l];
        //방향
        String[] direction = new String[l];

        // 각 배열에 변환할 시간과 변환할 방향 입력받기
        for(int i = 0; i < l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            second[i] = Integer.parseInt(st.nextToken());
            direction[i] = st.nextToken();
        }

        //처음 좌표 x, y
        int x = 1;
        int y = 1;
        //초를 세는 count 변수
        int count = 0;
        //현재 방향은 오른쪽이므로 3으로 설정
        int d = 3;
        //변환할 시간과 방향을 비교할 인덱스
        int index = 0;
        //처음 뱀이 있는 위치는 3으로 설정
        board[x][y] = 3;

        //현재 꼬리를 q에 삽입
        q.offer(new Position(x, y));

        while(true){
            // 초 카운트
            count++;

            //새로 이동할 mx,my 좌료 구함
            int mx = x + dx[d];
            int my = y + dy[d];

            //이동할 좌표의 값이 0이거나 3이면 (벽이거나 뱀의 몸) break
            if(board[mx][my] == 0 || board[mx][my] == 3) break;

            //이동할 좌표의 값이 1이면
            //뱀이 있음을 의미하는 3으로 값을 변경하고 현재 위치를 q에 삽입
            //q에서 꼬리를 꺼내 1로 만듦
            if(board[mx][my] == 1){
                board[mx][my] = 3;
                q.offer(new Position(mx,my));
                Position tail = q.poll();
                board[tail.x][tail.y] = 1;
            }
            //사과가 있다면
            //움직일 좌표 값을 3으로 변경하고
            //꼬리를 제거하지 않고 현재 위치만 q에 삽입
            else if(board[mx][my] == 2) {
                board[mx][my] = 3;
                q.offer(new Position(mx,my));
            }

            //현재 좌표 x는 움직일 좌표 mx로 설정
            //현재 좌표 y는 움직일 좌표 my로 설정
            x = mx;
            y = my;


            //만약 방향 변환할 시간이라면
            if(second[index] == count) {
                //오른쪽 방향이면 오른쪽으로 방향 변환해줌
                if (direction[index].equals("D")) {
                    d -= 1;
                    if (d < 0) d = 3;
                }
                //왼쪽 방향이면 왼쪽으로 방향 변환해줌
                else {
                    d += 1;
                    if (d > 3) d = 0;
                }
                //방향 변환 횟수가 남아있다면 index++
                if(index < l - 1) index++;
            }

        }

        // 정답 출력
        System.out.println(count);

    }
}
