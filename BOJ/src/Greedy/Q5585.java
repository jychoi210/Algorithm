package Greedy;

// 백준 그리디 Q5585 거스름돈
// https://www.acmicpc.net/problem/5585
// 1000엔을 낸 후 받을 거스름 돈의 최소 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5585 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //물건 값 입력 받기
        int price = Integer.parseInt(br.readLine());
        //거스름 돈 가격 구하기
        price = 1000 - price;

        int result = 0;
        int m = 500;
        int index = 1;

        //가능한 화폐 단위를 빼면서 count 한다.
        while(price > 0){
            if(price - m >= 0){
                result++;
                price -= m;
            }
            else{
                index++;
                if(index % 2 == 0) m = m / 5;
                else m = m / 2;
            }
        }

        System.out.print(result);
    }
}
