package Greedy;

// 이것이 코딩 테스트다.
// Chapter 11 : 그리디 기출 5 볼링공 고르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChoosingBowlingBall {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] weight = new int[m + 1];

        //각 무게의 볼링공이 몇 개 인지 입력 받기
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            weight[Integer.parseInt(st.nextToken())]++;
        }

        //총 만들 수 있는 경우의 수를 result에 저장
        int result = n*(n-1)/2;
        //만약 같은 무게가 2개 이상이면 같은 무게 2개를 뽑을 경우의 수를 뺴줌
        for(int i = 1; i < m + 1; i++){
            if(weight[i] >= 2){
                result -= weight[i] * (weight[i] - 1) / 2;
            }
        }
        System.out.print(result);

    }
}
