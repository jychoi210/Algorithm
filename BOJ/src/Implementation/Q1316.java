package Implementation;

// 백준 구현 Q1316 그룹 단어 체커
// https://www.acmicpc.net/problem/1316
// 문자열 중 연속된 단어로만 구성된 단어 판별

import java.io.*;
import java.util.*;

public class Q1316 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트 케이스 입력 받기
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0; i < n; i++){
            // 문자열 입력 받아 char 배열에 저장
            char[] word = br.readLine().toCharArray();
            boolean check = true;
            // 단어들 저장할 set
            Set<Character> character = new HashSet<Character>();
            // 맨 처음 단어를 set에 넣음
            character.add(word[0]);
            for(int j = 1; j < word.length; j++){
                //앞에 단어와 다른 단어일 경우
                if(word[j] != word[j-1]){
                    //character에 포함되어 있으면 이전에 나온 것이므로
                    if(character.contains(word[j])){
                        //false 설정
                        check = false;
                        break;
                    }
                    //character에 포함되어 있지 않으면 처음 나온 것이므로
                    else{
                        //set인 character에 추가
                        character.add(word[j]);
                    }
                }
            }
            //check값이 true인 것만 count
            if(check) result++;
        }
        System.out.print(result);
    }
}
