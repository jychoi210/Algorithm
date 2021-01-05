package Greedy;

// 이것이 코딩 테스트다.
// 그리디 03-3 숫자 카드 게임

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberCardGame {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        //int M = Integer.parseInt(NM[1]);
        int result = 0;

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            int[] num = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(num);
            if(result < num[0]) result = num[0];
        }

        System.out.print(result);

    }
}
