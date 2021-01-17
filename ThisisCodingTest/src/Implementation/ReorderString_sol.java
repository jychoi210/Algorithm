package Implementation;

// 이것이 코딩 테스트다.
// Chapter 12 : 구현 기출 2 문자열 재정렬 해답
// 문자는 문자끼리 모아서 정렬 + 숫자는 모두 합해서 같이 출력하기

// 아스키 코드 말고 Character.isLetter 사용해보기
// 숫자가 없을 경우 0이 출력되지 않게 주의

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ReorderString_sol {
    public static String s;
    public static int num = 0;
    public static ArrayList<Character> alpha = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for(int i = 0; i < s.length(); i++){
            //문자라면 alpha에 합치기
            if(Character.isLetter(s.charAt(i))){
                alpha.add(s.charAt(i));
            }
            //숫자라면 num에 더하기
            else{
                num += s.charAt(i) - '0';
            }
        }

        Collections.sort(alpha);

        //문자와 숫자 연결
        StringBuilder sb = new StringBuilder();
        for(char c : alpha){
            sb.append(c);
        }

        //숫자가 없을 경우에는 0을 출력하면 안됨
        if(num != 0) sb.append(num);

        //답 출력
        System.out.print(sb.toString());

    }

}
