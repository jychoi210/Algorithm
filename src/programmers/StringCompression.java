package programmers;

import java.util.Arrays;

public class StringCompression {
    public static void main(String args[]){
        System.out.println(solution("abcabcdede"));
    }

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
        System.out.println("result is : " + compressed);
        return compressed.length();
    }
}
