package DFS.BFS;

// 이것이 코딩 테스트다.
// Chapter 12 : DFS, BFS 기출 2 연구소 해답
// 삼성 전자 SW 역량테스트
// https://www.acmicpc.net/problem/14502

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Laboratory_sol {
    public static int n,m,result = 0;
    //연구소 정보와 비교할 temp 배열
    public static int[][] lab = new int[8][8];
    public static int[][] temp = new int[8][8];

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    //바이러스 퍼지게 하는 함수
    public static void virus(int x, int y){
        //x, y 상하좌우에 대해서 확인
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            //상하좌우가 0이라면 2로 바꿔주기
            if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                if(temp[nx][ny] == 0){
                    temp[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    //0인 경우만 세서 안전 영역 세기
    public static int countSafeArea(){
        int safeArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(temp[i][j] == 0) safeArea+=1;
            }
        }
        return safeArea;
    }

    //벽 설치하기
    public static void installWall(int count){
        //벽이 3개라면
        if(count == 3){
            //lab 배열을 temp에 복사
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    temp[i][j] = lab[i][j];
                }
            }

            //temp의 바이러스 위치를 통해 virus 퍼트리기
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(temp[i][j] == 2){
                        virus(i,j);
                    }
                }
            }

            //result와 벽 3개 설치 했을 때 영역 중 큰 것 선택
            result = Math.max(result, countSafeArea());
            return;
        }

        // 모든 i, j에 대하여
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //0이면 1을 더해 벽을 만든다.
                if(lab[i][j] == 0){
                    lab[i][j] = 1;
                    //벽의 개수 카운트
                    count+=1;
                    //카운트 하여 3-count만큼 설치
                    installWall(count);
                    //원상복구
                    lab[i][j] = 0;
                    count-=1;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //n,m 입력 받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //lab 배열 정보 입력 받기
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        installWall(0);
        System.out.print(result);
    }
}
