package Implementation;

// 백준 구현 Q14500 테트로미노
// https://www.acmicpc.net/problem/14500
// 가장 큰 값을 가지는 테트로미노 영역 구하기

import java.io.*;
import java.util.*;

public class Q14500 {
    public static int[][] board;
    public static int N, M;
    public static int max = 0, temp = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        one();
        two();
        three();
        four();
        five();
        System.out.print(max);

    }

    // ㅡ, ㅣ 모양
    public static void one(){
        // ㅡ 모양
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M - 3; j++){
                temp = board[i][j] + board[i][j+1] + board[i][j+2] + board[i][j+3];
                max = Math.max(max, temp);
            }
        }

        // ㅣ 모양
        for(int i = 0; i < N - 3; i++){
            for(int j = 0; j < M; j++){
                temp = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j];
                max = Math.max(max, temp);
            }
        }
    }

    // ㅁ 모양
    public static void two(){
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 1; j++){
                temp = board[i][j] + board[i][j+1] + board[i+1][j] + board[i+1][j+1];
                max = Math.max(temp, max);
            }
        }
    }

    // L 모양
    public static void three(){
        //L 모양
        for(int i = 0; i < N-2; i++){
            for(int j = 0; j < M-1; j++){
                temp = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+2][j+1];
                max = Math.max(max, temp);
            }
        }

        // L 좌우대칭 모양 ( _l )
        for(int i = 0; i < N-2; i++){
            for(int j = 0; j < M-1; j++){
                temp = board[i][j+1] + board[i+1][j+1] + board[i+2][j] + board[i+2][j+1];
                max = Math.max(max, temp);
            }
        }

        // L 상하대칭 모양 ( ㅣ- )ㅋㅋ
       for(int i = 0; i < N-2; i++){
            for(int j = 0; j < M-1; j++){
                temp = board[i][j] + board[i][j+1] + board[i+1][j] + board[i+2][j];
                max = Math.max(max, temp);
            }
        }

       // L 대각선 대칭 모양 ( -ㅣ )
        for(int i = 0; i < N-2; i++){
            for(int j = 0; j < M-1; j++){
                temp = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+2][j+1];
                max = Math.max(max, temp);
            }
        }

        // ㅡㅣ 모양
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 2; j++){
                temp = board[i+1][j] + board[i+1][j+1] + board[i+1][j+2] + board[i][j+2];
                max = Math.max(max, temp);
            }
        }

        // ㄴ- 모양
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 2; j++){
                temp = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+1][j+2];
                max = Math.max(max, temp);
            }
        }

        // -ㄱ 모양
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 2; j++){
                temp = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+2];
                max = Math.max(max, temp);
            }
        }

        // |-- 모양
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 2; j++){
                temp = board[i][j] + board[i+1][j] + board[i][j+1] + board[i][j+2];
                max = Math.max(max, temp);
            }
        }
    }

    public static void four(){
        // ㅗ 모양
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 2; j++){
                temp = board[i][j+1] + board[i+1][j] + board[i+1][j+1] + board[i+1][j+2];
                max = Math.max(max, temp);
            }
        }

        // ㅓ 모양
        for(int i = 0; i < N - 2; i++){
            for(int j = 0; j < M - 1; j++){
                temp = board[i][j+1] + board[i+1][j] + board[i+1][j+1] + board[i+2][j+1];
                max = Math.max(max, temp);
            }
        }

        // ㅜ 모양
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 2; j++){
                temp = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i][j+2];
                max = Math.max(max, temp);
            }
        }

        // ㅏ 모양
        for(int i = 0; i < N - 2; i++){
            for(int j = 0; j < M - 1; j++){
                temp = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j];
                max = Math.max(max, temp);
            }
        }
    }

    public static void five(){
        //'
        //' '
        //  '  모양
        for(int i = 0; i < N -2; i++){
            for(int j = 0; j < M - 1; j++){
                temp = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j+1];
                max = Math.max(max, temp);
            }
        }

        //   ' '
        // ' '    모양
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 2; j++){
                temp = board[i][j+1] + board[i][j+2] + board[i+1][j] + board[i+1][j+1];
                max = Math.max(max, temp);
            }
        }

        //   '
        // ' '
        // '   모양
        for(int i = 0; i < N -2; i++){
            for(int j = 0; j < M - 1; j++){
                temp = board[i+1][j] + board[i+2][j] + board[i][j+1] + board[i+1][j+1];
                max = Math.max(max, temp);
            }
        }

        // ' '
        //   ' ' 모양
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 2; j++){
                temp = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+1][j+2];
                max = Math.max(max, temp);
            }
        }
    }
}
