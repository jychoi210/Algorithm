package String;

// 백준 문자열 Q1764 듣보잡
// https://www.acmicpc.net/problem/1764
// 듣지 못한 사람과 보지 못한 사람 명단 중 듣지도 보지도 못한 사람의 명단을 사전순으로 출력

import java.io.*;
import java.util.*;

public class Q1764 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //듣지 못한 사람의 수
        int N = Integer.parseInt(st.nextToken());
        //보지 못한 사람의 수
        int M = Integer.parseInt(st.nextToken());

        //듣지 못한 사람 정보 담을 배열
        String[] dontListen = new String[N];

        //듣지 못한 사람 정보 입력받아 저장
        for(int i = 0; i < N; i++){
            String name = br.readLine();
            dontListen[i] = name;
        }

        //듣지 못한 사람 정보 정렬
        Arrays.sort(dontListen);

        //듣지도 보지도 못한 사람 정보 담을 리스트
        ArrayList<String> dbj = new ArrayList<>();
        //이름 저장용
        StringBuilder sb = new StringBuilder();
        //듣보잡 수
        int count = 0;

        for(int i = 0; i < M; i++){
            String name = br.readLine();
            //듣지 못한 사람에서 보지 못한 사람의 이름이 있다면 (binarySearch결과 양수가 나옴)
            if(Arrays.binarySearch(dontListen, 0, N, name) >= 0){
                //듣보잡 수 증가
                count++;
                //듣보잡에 이름 추가
                dbj.add(name);
            }
        }

        //사전순으로 출력하기 위해 정렬
        Collections.sort(dbj);

        //듣보잡 명단 sb에 저장
        for(String s : dbj){
            sb.append(s).append("\n");
        }

        //출력
        System.out.print(count + "\n" + sb.toString());
    }
}
