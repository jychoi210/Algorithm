package Implementation;

// 백준 구현 Q1157 단어 공부
// https://www.acmicpc.net/problem/1157
// 가장 많이 쓰인 문자 대문자로 출력하기

//시간이 너무 많이 걸리므로 아스키코드로 푸는 것이 좋겠음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1157 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //모두 대문자로 바꿈
        s = s.toUpperCase();
        //Map에 있으면 value+1, 없으면 map에 삽입
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(String.valueOf(s.charAt(i)))){
                map.replace(String.valueOf(s.charAt(i)), map.get(String.valueOf(s.charAt(i))) + 1);
            }
            else{
                map.put(String.valueOf(s.charAt(i)), 1);
            }
        }

        //value값으로 정렬
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(((o1, o2) -> map.get(o2)-map.get(o1)));

        //정렬된 키와 값들 중 제일 위 2개를 저장
        //두개의 value가 같으면 "?"출력, 같지 않으면 key 출력
        int index = 0;
        int[] result = new int[2];
        String[] key = new String[2];
        for (String nKey : keySet)
        {
            if(index == 2) break;
            result[index] = map.get(nKey);
            key[index] = nKey;
            index++;
        }

        System.out.print(result[0]==result[1] ? "?" : key[0]);
    }
}
