package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 16 : 다이나믹 프로그래밍 기출 6 편집 거리 해답
// Goldman Sachs Interview

// 최소 편집 거리(Minimum Edit Distance) 알고리즘
// 두 개의 문자열이 같아지기 위해서 몇 번의 추가, 편집, 삭제가 이루어져야 하는지 그 최소 개수를 구하는 알고리즘
// 왼쪽인 경우 : 열에 해당하는 단어를 삭제
// 왼쪽 위인 경우 : 열에 해당하는 단어를 행에 해당하는 단어로 교체
// 위쪽인 경우 : 행에 해당하는 단어를 추가

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance_sol {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //문자열 A, B 입력 받기
        String A = br.readLine();
        String B = br.readLine();
        //문자열 A, B 크기 저장
        int sizeA = A.length();
        int sizeB = B.length();

        //dp 테이블
        int[][] dp = new int[sizeA+1][sizeB+1];

        //0행 초기화
        for(int i = 0; i < sizeA; i++){
            dp[i][0] = i;
        }

        //0열 초기화
        for(int j = 0; j < sizeB; j++){
            dp[0][j] = j;
        }

        //행과 열에 해당하는 문자가 같다면 왼쪽 위의 값 그대로 대입
        //행과 열에 해당하는 문자가 다르다면 왼쪽(삽입), 위쪽(삭제), 왼쪽 위(교체)에 해당하는 수 중 가장 작은 수 + 1
        for(int i = 0; i < sizeA; i++){
            for(int j = 0; j < sizeB; j++){
                if(A.charAt(i) == B.charAt(j)) dp[i+1][j+1] = dp[i][j];
                else dp[i+1][j+1] = 1 + Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i][j]));
            }
        }
        System.out.print(dp[sizeA][sizeB]);
    }
}
