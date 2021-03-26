package String;

// 백준 문자열 Q1541 잃어버린 괄호
// https://www.acmicpc.net/problem/1541
// 괄호를 적절히 배치하여 식의 값을 최소로 만들기

import java.io.*;
import java.util.*;

public class Q1541 {
    public static void main(String agrs[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 받은 연산 -를 기준으로 배열 만들기
        String[] str = br.readLine().split("-");

        int sum = 0;

        //연산에 -가 없는 경우
        if(str.length == 1){
            //배열을 다시 String 형태로 바꿈
            String temp = Arrays.toString(str);
            temp = temp.substring(1,temp.length()-1);

            // +를 기준으로 배열 만들기
            String[] add = temp.split("\\+");

            //각 숫자 더하기
            for(int i = 0; i < add.length; i++){
                sum += Integer.parseInt(add[i]);
            }
        }
        //연산에 -가 있는 경우
        else{
            //배열의 맨 앞 부분은 더해야 함
            String[] add = str[0].split("\\+");
            //각 숫자 더하기 ( -가 나오기 전까지의 +는 더하기 연산 해주어야 함)
            for(int i = 0; i < add.length; i++){
                sum += Integer.parseInt(add[i]);
            }

            // 맨 첫 인덱스 이후의 값은 모두 빼야 함
            for(int i = 1; i < str.length; i++){
                //각 연산들을 +로 나누어서 각 숫자들 뺴줌
                String[] sub = str[i].split("\\+");
                for(int j = 0; j < sub.length; j++){
                    sum -= Integer.parseInt(sub[j]);
                }
            }
        }

        System.out.print(sum);
    }
}
