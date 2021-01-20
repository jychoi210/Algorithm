package Implementation;

// 백준 구현 Q1157 단어 공부 해답
// https://www.acmicpc.net/problem/1157
// 가장 많이 쓰인 문자 대문자로 출력하기

import java.io.IOException;

public class Q1157_sol {
    public static void main(String args[]) throws IOException {
        //영문의 개수
        int[] s = new int[26];
        //문자 한개씩 아스키 코드로 저장
        int c = System.in.read();

        //c가 65 이상일 때 만 반복
        while(c >= 'A'){
            // 91보다 작으면 대문자 이므로 알파벳 순서 인덱스에 1 증가
            if(c < 91) {
                s[c - 'A']++;
            }
            // 91보다 크거나 같으면 소문자 이므로 알파벳 순서 인덱스에 1 증가
            else{
                s[c - 'a']++;
            }
            //다음 문자 입력받기
            c = System.in.read();
        }

        //큰 값을 비교
        int max = -1;
        //반환할 문자, 기본값은 '?'로 설정 (?의 아스키코드는 63)
        int ch = -2;

        //각 문자의 개수를 비교하여 max값을 구함
        //max값이 중복되었을 경우에는 ch를 2로 설정하여 ?를 출력하게 함
        for(int i = 0; i < 26; i++){
            if(s[i] > max){
                max = s[i];
                ch = i;
            }else if(s[i] == max){
                ch = -2;
            }
        }

        System.out.print((char) (ch+65));
    }
}
