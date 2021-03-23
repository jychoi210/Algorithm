package BruteForce;

// 백준 브루트포스 Q1018 체스판 다시 칠하기
// https://www.acmicpc.net/problem/1018
// 체스판을 8x8로 잘라 칠할 최소 칸 구하기

import java.io.*;
import java.util.*;

public class Q1018 {
    public static int min = 250;
    public static char[][] board;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //입력받을 체스판
        board = new char[n][m];

        // 체스판 색 입력 받기
        for(int i = 0; i < n; i++){
            board[i] = br.readLine().toCharArray();
        }

        // 모든 경우의 수의 최소 값 구하기
        for(int i = 0; i <= n-8; i++){
            for(int j = 0; j <= m-8; j++){
                min = Math.min(check(i,j), min);
            }
        }
        System.out.print(min);
    }

    //최소 값 구하는 함수
    public static int check(int i, int j){
        //white가 먼저 나올 경우, black이 먼저 나올 경우
        int white = 0, black = 0;
        for(int x = i; x < i + 8; x++){
            for(int y = j; y < j + 8; y++){
                if(x % 2 == 0){
                    if(y % 2 == 0){
                        if(board[x][y] != 'W') white++;
                        else black++;
                    }else{
                        if(board[x][y] != 'B') white++;
                        else black++;
                    }
                }else{
                    if(y % 2 == 0){
                        if(board[x][y] != 'B') white++;
                        else black++;
                    }else{
                        if(board[x][y] != 'W') white++;
                        else black++;
                    }
                }
            }
        }
        //최소값 반환
        return Math.min(black, white);
    }
}
