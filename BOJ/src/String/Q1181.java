package String;

// 백준 문자열 Q1181 단어 정렬
// https://www.acmicpc.net/problem/1181
// 입력 받은 단어 정렬

import java.io.*;
import java.util.*;

public class Q1181 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> words = new ArrayList<String>();
        //단어 입력 받기
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            words.add(temp);
        }

        br.close();

        //단어 정렬하기
        Collections.sort(words, new Comparator<String>(){
            public int compare(String word1, String word2){
                //2. 길이가 같다면 알파벳 순으로 정렬
                if(word1.length()==word2.length()) return word1.compareTo(word2);
                //1. 길이 순으로 정렬
                return Integer.compare(word1.length(), word2.length());
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(words.get(0)).append("\n");
        //중복되지 않는다면 stringbuilder에 추가
        for(int i = 1; i < words.size(); i++){
            if(!words.get(i).equals(words.get(i-1))) sb.append(words.get(i)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
