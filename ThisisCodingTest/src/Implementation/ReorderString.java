package Implementation;

// 이것이 코딩 테스트다.
// Chapter 12 : 구현 기출 2 문자열 재정렬
// 문자는 문자끼리 모아서 정렬 + 숫자는 모두 합해서 같이 출력하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReorderString {
    public static void main(String args[]) throws IOException {
        boolean flag = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //숫자의 합을 저장할 변수
        int num = 0;
        //문자를 저장할 리스트
        ArrayList<Character> alpha = new ArrayList<>();
        //s 입력 받기
        String s = br.readLine();

        //숫자라면 num에 더하고 문자라면 alpha에 추가
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 48 && s.charAt(i) <= 57 ){
                num += s.charAt(i) - '0';
                flag  = true;
            }else{
                alpha.add(s.charAt(i));
            }
        }

        //문자 정렬
        Collections.sort(alpha);

        //문자와 숫자 연결
        StringBuilder sb = new StringBuilder();
        for(char c : alpha){
            sb.append(c);
        }

        //숫자가 나왔을 경우 num 뒤에 합치기
        if(flag) sb.append(num);

        //답 출력
        System.out.print(sb.toString());

    }
}
