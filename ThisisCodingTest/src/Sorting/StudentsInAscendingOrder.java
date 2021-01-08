package Sorting;

// 이것이 코딩 테스트다.
// Chapter 6 : 정렬 문제 2 성적이 낮은 순서로 학생 출력하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class StudentsInAscendingOrder {
    public static void main(String args[]) throws Exception{
        //값을 저장할 Hashmap 선언
        HashMap<Integer, String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N 입력받기
        int N = Integer.parseInt(st.nextToken());

        //N만큼 학생들 정보 입력받기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            int key = Integer.parseInt(st.nextToken());
            map.put(key, value);
        }

        //key를 array로 만든 후 정렬
        Object[] mapkey = map.keySet().toArray();
        Arrays.sort(mapkey);

        //정렬된 key값에 맞는 value 출력
        for(Integer nKey : map.keySet()){
            System.out.print(map.get(nKey) + " ");
        }

    }
}
