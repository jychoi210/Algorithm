package Greedy;

// 이것이 코딩 테스트다.
// 그리디 03-2 큰 수의 법칙

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RuleOfGreatNumbers {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[] array = new int[N];

        String[] num = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(num[i]);
        }

        Arrays.sort(array);
        /* for문 버전
        int result = array[N-1];
        for(int i = 1; i < M; i++){
            if(i % K == 0){
                result += array[N-2];
            }else{
                result += array[N-1];
            }
        }
        */
        int result = 0;
        System.out.print(result);
    }
}
