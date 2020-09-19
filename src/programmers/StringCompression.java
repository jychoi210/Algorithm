package programmers;
/*문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.*/

import java.util.Arrays;

public class StringCompression {
    public static void main(String args[]){
        System.out.println(solution("abcabcdede"));
    }

    // 1부터 s.length()/2 만큼 문자열을 잘라 제일 짧게 압축된 문자열 길이를 리턴
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

    //String 배열 안의 문자열들을 비교하여 압축하는 함수
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
        System.out.println("result is : " + compressed);
        return compressed.length();
    }
}
