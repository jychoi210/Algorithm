package Greedy;

// 이것이 코딩 테스트다.
// Chapter 11 : 그리디 기출 2 곱하기 혹은 더하기
// 0이나 1이면 더하고, 2 이상이면 곱한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MultiplyOrAdd {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split("");
        //문자열로 입력받아 배열로 만든 후 int 배열로 변환
        int[] num = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();

        //첫번째 수를 result에 넣음
        int result = num[0];

        //1부터 n-1까지 반복
        //현재까지 계산한 값(result)가 0이나 현재 수를 더함. 0이나 1이 아니라면 현재 수를 곱함.
        //현재 수(num[i])가 0이나 1이면 수를 더함. 0이나 1이 아니라면 수를 곱함
        for(int i = 1; i < num.length; i++){
            if(num[i] == 0 || num[i] == 1 || result == 0 || result == 1) result += num[i];
            else result *= num[i];
        }

        System.out.print(result);

    }
}
