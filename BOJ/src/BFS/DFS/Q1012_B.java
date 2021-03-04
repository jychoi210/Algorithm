package BFS.DFS;

// 백준 BFS Q1012 유기농 배추
// https://www.acmicpc.net/problem/1012
// 인접한 배추 그룹의 개수 구하기 (BFS 버전)

import java.io.*;
import java.util.*;

public class Q1012_B {
    public static int m,n,k;
    public static int[][] map;
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 수 입력 받기
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int x, y, mx, my;

        // 테스트 케이스 수만큼 반복하여 배추 그룹 개수 구하기
        for(int t = 0; t < test; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            // map을 m x n으로 초기화
            map = new int[m][n];

            // 배추가 있는 위치 정보 입력 받기
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            Queue<Integer> q = new LinkedList<Integer>();
            int result = 0;

            // map에 대하여
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    //배추가 있는 곳이면 q에 삽입, 그룹 개수 세기
                    if(map[i][j] == 1){
                        q.offer(i);
                        q.offer(j);
                        result++;
                    }

                    // q가 빌때 까지 반복
                    while(!q.isEmpty()){
                        //q의 x, y 정보 받아오기
                        x = q.poll();
                        y = q.poll();
                        // 방문한 곳은 -1로 표시
                        map[x][y] = -1;

                        // 모든 방향에 대하여 확인
                        for (int d = 0; d < 4; d++) {
                            mx = x + dx[d];
                            my = y + dy[d];
                            //새로운 위치 mx, my가 map 범위 내라면
                            if(mx >= 0 && mx < m && my >= 0 && my < n){
                                //그리고 배추가 있다면
                                if(map[mx][my] == 1){
                                    // q에 새로운 mx, my 추가
                                    q.offer(mx);
                                    q.offer(my);
                                    // *** 미리 -1을 해주지 않으면(방문 표시), 큐에 중복되어 들어가 메모리가 초과됨 ***
                                    map[mx][my] = -1;
                                }
                            }
                        }

                    }

                }
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
    }
}
