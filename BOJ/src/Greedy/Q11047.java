package Greedy;

// 백준 그리디 Q11047 동전 0
// https://www.acmicpc.net/problem/11047
// K원을 만드는 데 필요한 동전 개수의 최솟값 출력

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11047 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //n과 k 입력 받기
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //동전 가치 저장할 배열 입력 받을 배열
        int[] money = new int[n];

        //동전 가치 입력 받기
        for(int i = 0; i < n; i++){
            money[i] = Integer.parseInt(br.readLine());
        }

        //money 중 가장 큰 수 부터 시작,
        //k에서 money[i]를 뺀 후 0보다 크거나 같다면 result++해준 후, k에서 money[i]만큼 빼줌
        // money[i]보다 k가 작다면 i를 1 감소 시켜 다음으로 큰 동전 사용
        int result = 0;
        int i = money.length - 1;
        while(i >= 0){
            if(k == 0) break;
            if(k-money[i] >= 0) {
                k = k - money[i];
                result++;
            }
            else i--;
        }

        System.out.print(result);
    }
}
