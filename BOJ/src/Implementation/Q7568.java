package Implementation;

// 백준 구현 Q7568 덩치
// https://www.acmicpc.net/problem/7568
// 키와 몸무게가 모두 크면 덩치가 큰 것, 덩치 등수 나타내라

import java.io.*;
import java.util.*;

// 몸무게와 키 정보를 저장할 클래스
// 클래스 없이 배열로도 가능
class Person{
    int w;
    int h;
    int r;

    public Person(int w, int h){
        this.w = w;
        this.h = h;
        this.r = 1;
    }
}

public class Q7568 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 사람 수 입력 받기
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> people = new ArrayList<Person>();
        StringTokenizer st;
        // 사람 몸무게, 키 정보 입력 받기
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            people.add(new Person(w, h));
        }

        //결과 값을 저장할 String Builder
        StringBuilder sb = new StringBuilder();

        // 모든 경우를 탐색하며 자기보다 키, 몸무게가 크면 등수 + 1
        for(int i = 0; i < n; i++){
            Person p1 = people.get(i);
            for(int j = 0; j < n; j++){
                Person p2 = people.get(j);

                if(p1.w < p2.w && p1.h < p2.h){
                    p1.r+=1;
                }
            }
            sb.append(p1.r).append(" ");
        }
        System.out.print(sb.toString());
    }
}
