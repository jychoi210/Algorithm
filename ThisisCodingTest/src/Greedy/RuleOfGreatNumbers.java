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

        //for문 버전
        //우선 가장 큰 수를 더한 후,
        int result = array[N-1];

        //1부터 반복하며 가장 큰 수를 더하다가 k의 배수 번째가 되면 두 번째로 큰 수를 더한다.
        for(int i = 1; i < M; i++){
            if(i % K == 0){
                result += array[N-2];
            }else{
                result += array[N-1];
            }
        }

        System.out.print(result);
    }
}
