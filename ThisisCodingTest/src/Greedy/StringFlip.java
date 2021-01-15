package Greedy;

// 이것이 코딩 테스트다.
// Chapter 11 : 그리디 기출 3 문자열 뒤집기
// 문자열을 입력 받아 연속된 하나 이상의 숫자를 잡고 모두 뒤집에 결과적으로 같은 숫자로 만들기 (0011100 -> 0000000)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringFlip {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //문자열 s 입력 받아 String 배열로 만들기
        String[] s = br.readLine().split("");
        //String 배열 int 배열로 변환
        int[] num = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        //연속된 0 집합 개수
        int zero = 0;
        //연속된 1 집합 개수
        int one = 0;

        //0부터 num.length-1 까지 반복
        for(int i = 0; i < num.length - 1; i++){
            //앞의 수와 뒤의 수가 다를 경우
            if(num[i] != num[i+1]){
                //0집합이면 zero++
                if(num[i] == 0) zero++;
                //1집합이면 one++
                else one++;
            }
        }

        //zero와 one 중 더 작은 것을 출력
        System.out.print(zero>one ? one : zero);
    }
}
