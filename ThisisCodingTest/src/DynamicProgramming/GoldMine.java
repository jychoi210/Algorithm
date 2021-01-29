package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 16 : 다이나믹 프로그래밍 기출 1 금광
// Flipkart Interview

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoldMine {
    //금광 크기 n,m
    public static int n, m;

    //금의 개수 찾기
    public static int findMax(int[][] gold, int x, int y){
        //처음 시작점의 금의 개수를 더함
        int sum = gold[x][y];
        // m-1번 반복하여 금을 캔다.
        for(int i = 1; i < m; i++){
            // 현재 x값이 맨 위라면
            if(x == 0){
                // 오른쪽과 오른쪽 아래만 비교하여 x, y 값 갱신
                if(gold[x][y+1] > gold[x+1][y+1]){
                    sum += gold[x][y+1];
                    y = y+1;
                }else{
                    sum += gold[x+1][y+1];
                    x = x+1;
                    y = y+1;
                }
            }
            // 현재 x값이 맨 아래라면
            else if(x == n - 1){
                // 오른쪽과 오른쪽 위만 비교하여 x, y 값 갱신
                if(gold[x][y+1] > gold[x-1][y+1]){
                    sum += gold[x][y+1];
                    y = y+1;
                }else{
                    sum += gold[x-1][y+1];
                    x = x-1;
                    y = y+1;
                }
            }
            // x값이 중간이라면
            else{
                // 오른쪽 위, 오른쪽, 오른쪽 아래 값 비교하여 x, y값 갱신
                if((gold[x-1][y+1] > gold[x][y+1]) && (gold[x-1][y+1] > gold[x+1][y+1])){
                    sum += gold[x-1][y+1];
                    x = x-1;
                    y = y+1;
                }else if((gold[x][y+1] > gold[x-1][y+1]) && gold[x][y+1] > gold[x+1][y+1]){
                    sum += gold[x][y+1];
                    y = y+1;
                }else{
                    sum += gold[x+1][y+1];
                    x = x+1;
                    y = y+1;
                }
            }
        }
        //금의 개수 반환
        return sum;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //테스트 케이스 개수 입력 받기
        int t = Integer.parseInt(br.readLine());
        //테스트 케이스 개수만큼 반복
        for(int tNum = 0; tNum < t; tNum++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            //금광 개수 입력 받기
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            //금광 배열 만들기
            int[][] gold = new int[n][m];

            //금광의 금의 개수들 입력 받기
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    gold[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            int tmp = 0;
            //시작점을 총 n개로 하여 최대 금의 개수 찾기
            for(int i = 0; i < n; i++){
                tmp = findMax(gold, i, 0);
                if(max < tmp) max = tmp;
            }

            sb.append(max).append("\n");
        }
        //출력
        System.out.print(sb.toString());
    }
}
