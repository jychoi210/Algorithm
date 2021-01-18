package Implementation;

// 이것이 코딩 테스트다.
// Chapter 12 : 구현 기출 3 문자열 압축 (이전에 풀었던 코드)
// 프로그래머스 2020 카카오 신입 공채 (level 2)
// https://programmers.co.kr/learn/courses/30/lessons/60057

import java.util.*;

public class StringCompression_before {

    public static int solution(String s) {
        int answer = 0;
        int min = s.length();
        String[] temp = s.split("");
        for(int i = 1; i < s.length()/2 + 1; i++){
            for(int j = i - 1; j < s.length(); j+=i){
                temp[j] = temp[j] + ";";

            }
            String temp2 = Arrays.toString(temp);
            temp2 = temp2.replace("[","");
            temp2 = temp2.replace("]","");
            temp2 = temp2.replace(" ","");
            temp2 = temp2.replace(",","");

            answer = compare(temp2.split(";"));

            if(answer < min){
                min = answer;
            }
            temp = s.split("");
        }
        return min;
    }

    public static int compare(String[] s){
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for(int i = 0; i < s.length - 1; i++){
            if(s[i].equals(s[i+1])){
                count++;
            }else{
                if(count == 1){
                    compressed.append(s[i]);
                }
                else{
                    compressed.append(count);
                    compressed.append(s[i]);
                }
                count = 1;
            }

            if(i == s.length - 2){
                if(count == 1){
                    compressed.append(s[i + 1]);
                }
                else{
                    compressed.append(count);
                    compressed.append(s[i + 1]);
                }
            }
        }
        return compressed.length();
    }

    public static void main(String args[]){
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

}
