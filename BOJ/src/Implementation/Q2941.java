package Implementation;

// 백준 구현 Q2941 크로아티아 알파벳
// https://www.acmicpc.net/problem/2941
// 주어진 단어에서 크로아티아 알파벳 개수 출력

import java.io.*;

public class Q2941 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 단어를 입력 받아 배열로 저장
        char[] words = br.readLine().toCharArray();
        // 배열 크기 저장
        int size = words.length;
        int count = 0;
        for(int i = 0; i < size; i++){
            // 현재 단어 word에 저장
            char word = words[i];
            // 현재 단어가 c이고 마지막 단어가 아니라면
            if(word == 'c' && i < size - 1){
                // 그 다음 단어가 =이거나 - 이면 한 단어로 취급, 따라서 그 다음 단어부터 체크(i++ 해줌)
                if(words[i+1] == '=' || words[i+1] == '-'){
                    i++;
                }
            }
            // 현재 단어가 d이고, 마지막 단어가 아니라면
            else if(word == 'd' && i < size - 1){
                // 그 다음 단어가 z이고, z가 마지막 단어가 아니라면
                if(words[i+1] == 'z' && i < size - 2){
                    // 그 다음 단어가 = 이라면 한 단어로 취급, 따라서 그 다음 단어부터 체크(i+=2 해줌)
                    if(words[i+2] == '=') {
                        i += 2;
                    }
                }
                // 그 다음 단어가 -이면
                else if(words[i+1] == '-'){
                    // 한 단어로 취급, 따라서 그 다음 단어부터 체크
                    i++;
                }
            }
            // 현재 단어가 l이거나 n이고, 마지막 단어가 아니라면
            else if((word == 'l' || word == 'n') && i  < size - 1){
                // 그 다음 단어가 j라면, 한 단어로 취급
                if(words[i+1] == 'j') {
                    i++;
                }
            }
            // 현재 단어가 s이거나 z이고, 마지막 단어가 아니라면
            else if((word == 's' || word=='z') && i < size - 1){
                // 그 다음단어가 =이리면, 한 단어로 취급
                if(words[i+1] == '='){
                    i++;
                }
            }
            count++;
        }
        System.out.print(count);
    }
}


