package Implementation;

// 백준 그리디 Q1110 더하기 사이클 해
// https://www.acmicpc.net/problem/1110
// N의 사이클 구하기답
// string이 아닌 숫자의 자리로 풀기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1110_sol {
    public static void main(String args[]) throws IOException {
        //n 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //처음 temp값은 n으로 설정
        int temp = n;
        //결과 값 저장 변수
        int count = 0;
        //새 temp는 원래 수의 일의자리 * 10 + 일의자리, 십의자리 더한 값의 일의 자리
        while(true){
            temp = ((temp % 10) * 10) + (((temp % 10) + (temp / 10)) % 10);
            count++;
            //temp와 n이 같다면 무한루프 종료
            if(temp == n) break;
        }
        System.out.print(count);
    }
}
