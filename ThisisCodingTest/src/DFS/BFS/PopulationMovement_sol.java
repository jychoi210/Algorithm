package DFS.BFS;

// 이것이 코딩 테스트다.
// Chapter 13 : DFS, BFS 기출 7 인구 이동 해답
// 삼성전자 SW 역량테스트
// https://www.acmicpc.net/problem/16234

// 각 연합에 대한 번호 정보를 가진 unions 배열, 큐, 각 연합의 실제 정보를 담고 있는 united 리스트 이용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

//각 국가 좌표
class Nation{
    int x;
    int y;

    public Nation(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class PopulationMovement_sol {
    public static int n,L,R,result;
    public static int[][] land = new int[50][50];
    public static int[][] unions = new int[50][50];

    //상하좌우를 보기 위함
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void move(int x, int y, int index){
        //연합 국가
        ArrayList<Nation> united = new ArrayList<>();
        //현재 국가 연합에 넣음
        united.add(new Nation(x,y));

        //큐 만들어서 큐에도 넣음
        Queue<Nation> q = new ArrayDeque<>();
        q.offer(new Nation(x,y));

        //연합 번호를 unions에 넣음
        unions[x][y] = index;
        //현재 연합의 전체 인구 수
        int people = land[x][y];
        //현재 연합 국가 수
        int count = 1;

        while(!q.isEmpty()){
            //큐에서 새로운 국가 추출
            Nation nation = q.poll();
            x = nation.x;
            y = nation.y;
            //상하좌우 확인
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //nx,ny가 땅 범위 안에 있고, 연합에 속해있지 않는 경우
                if(0 <= nx && nx < n && ny < n && 0 <= ny && unions[nx][ny] == -1){
                    //인구 수 차이가 L이상 R이하인지 확인
                    int gap = Math.abs(land[nx][ny] - land[x][y]);
                    if( L <= gap && gap <= R){
                        //인구 수가 L이상 R이하 차이난다면 큐에 삽입
                        q.offer(new Nation(nx,ny));
                        //연합 번호 부여
                        unions[nx][ny] = index;
                        //연합 인구수 구하기
                        people += land[nx][ny];
                        //연합 국가수 + 1
                        count += 1;
                        //연합국들에 추가
                        united.add(new Nation(nx,ny));
                    }
                }
            }
        }
        //연합국가끼리 인구 이동
        for(int i = 0; i < united.size(); i++){
            x = united.get(i).x;
            y = united.get(i).y;
            land[x][y] = people/count;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            //연합 번호 -1로 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    unions[i][j] = -1;
                }
            }
            int index = 0;
            //연합 번호가 부여되지 않은 국가에 대해서 move함수 호출한 후, 연합 번호 + 1
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(unions[i][j] == -1){
                        move(i,j,index);
                        index++;
                    }
                }
            }
            //index가 n*n일 때가 최대이므로 break;
            if(index == n*n) break;
            //인구이동 횟수 + 1
            result++;
        }


        System.out.println(result);
    }
}
