package Implementation;

// 이것이 코딩 테스트다.
// Chapter 12 : 구현 기출 4 자물쇠와 열쇠 해답
// 프로그래머스 2020 카카오 신입 공채 (level 3)
// https://programmers.co.kr/learn/courses/30/lessons/60059

// lock 배열의 3배 크기의 배열을 만듦

import java.util.Arrays;

public class LockNKey_sol {
    public static boolean unlock(int[][] key, int[][] lock){
        //자물쇠와 열쇠 배열 크기 저장
        int n = lock.length;
        int m = key.length;

        //자물쇠의 3배 크기의 배열 만들기
        int[][] temp = new int[n * 3][n * 3];
        //중앙에 자물쇠 값 저장하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i + n][j + n] = lock[i][j];
            }
        }

        //4가지 방향
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotate(key);

            //자물쇠에 열쇠 더하기
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            temp[x + i][y + j] += key[i][j];
                        }
                    }
                    //열쇠가 정확히 맞다면 true 반환
                    if (check(temp)) return true;
                    //다시 원상태 만들기. 열쇠 뺴기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            temp[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }

    // 자물쇠를 확인하여 모든 배열의 값이 1이면 딱 들어 맞는 것으로 간주
    public static boolean check(int[][] lock){
        int size = lock.length / 3;
        for(int i = size; i < size * 2; i++){
            for(int j = size; j < size * 2; j++){
                if(lock[i][j] != 1) return false;
            }
        }
        return true;
    }

    //배열 회전 함수
    public static int[][] rotate(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotate[j][n-i-1] = arr[i][j];
            }
        }
        return rotate;
    }

    public static void main(String args[]){
        int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
        int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
        unlock(key, lock);
        System.out.print(unlock(key, lock));
    }
}
