package Implementation;

// 이것이 코딩 테스트다.
// Chapter 12 : 구현 기출 4 자물쇠와 열쇠
// 프로그래머스 2020 카카오 신입 공채 (level 3)
// https://programmers.co.kr/learn/courses/30/lessons/60059

// 맞는지 확인하기 위해서 자물쇠와 열쇠를 더한다는 아이디어
// n,m을 public static int로 선언하여 입력값을 다른 함수에서 쓸 수 없었음

public class LockNKey {
    public static boolean unlock(int[][] key, int[][] lock){
        //n, m 입력 받기
        int n = lock.length;
        int m = key.length;
        //size를 n + (m-1)*2로 설정
        int size = n+(m-1)*2;
        int[][] temp =  new int[size][size];

        //자물쇠 부분을 가운데에 넣음
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[m-1+i][m-1+j] = lock[i][j];
            }
        }

        //4가지 방향에 대해 확인
        for(int rotation = 0; rotation < 4; rotation++) {
            //key를 90도로 회전
            key = rotate(key);

            //i와 J는 key를 비교할 범위
            //0부터 n+m-1까지 i 반복
            for (int i = 0; i < size - m + 1; i++) {
                //0부터 n+m-1까지 j 반복
                for (int j = 0; j < size - m + 1; j++) {
                    //x, y는 키의 각각 구성을 비교
                    //x는 0부터 m까지 비교
                    for(int x = 0; x < m; x++){
                        //y는 0부터 m까지 비교
                        for(int y = 0; y < m; y++){
                            //temp에 key값을 더함
                            temp[x + i][y + j] += key[x][y];
                        }
                    }
                    //temp에서 자물쇠 부분만 봐서 다 1이라면 true 반환
                    if (check(temp,n,m)) return true;

                    //temp에서 다시 키 부분 빼줌
                    for(int x = 0; x < m; x++){
                        for(int y = 0; y < m; y++){
                            temp[x + i][y + j] -= key[x][y];
                        }
                    }
                }
            }
        }
        return false;
    }

    //입력 받은 lock 배열 중 자물쇠 부분이 모두 1이면 true를 반환, 아니면 false를 반환
    public static boolean check(int[][] lock, int n, int m){
        for(int i = m - 1; i < m - 1 + n; i++){
            for(int j = m - 1; j < m - 1 + n; j++){
                if(lock[i][j] != 1) return false;
            }
        }
        return true;
    }

    //2차원 배열을 90도로 회전하는 함수
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
        System.out.print(unlock(key, lock));
    }

}
