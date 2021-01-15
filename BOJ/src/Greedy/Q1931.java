package Greedy;

// 백준 그리디 Q1931 회의실 배정
// https://www.acmicpc.net/problem/1931
// 최대 사용할 수 있는 회의의 최대 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Schedule implements Comparable<Schedule>{
    int start;
    int end;

    public Schedule(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    @Override
    //끝나는 시간이 빠른 순으로 정렬
    //끝나는 시간이 같다면 시작하는 시간이 빠른 순으로 정렬
    public int compareTo(Schedule o){
        if(this.getEnd() == o.getEnd()) return this.getStart() - o.getStart();
        return this.getEnd() - o.getEnd();
    }
}

public class Q1931 {
    //입력 받을 회의 수 n
    public static int n;
    //각 회의 시작 시간과 끝나는 시간을 저장할 리스트
    public static ArrayList<Schedule> arrayList = new ArrayList<Schedule>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //회의 수 입력 받기
        n = Integer.parseInt(br.readLine());

        //arraylist에 각 회의 시작 시간과 끝나는 시간 입력
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arrayList.add(new Schedule(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        //회의 정렬
        Collections.sort(arrayList);

        int count = 0;
        int start;
        int end = -1;
        //회의 시작 시간이 이전 끝나는 시간보다 크거나 같다면
        //가능한 회의 수 1 증가, end는 마지막 회의의 끝나는 시간으로 갱신
        for(int i = 0; i < n; i++){
            start = arrayList.get(i).getStart();
            if(start >= end){
                end = arrayList.get(i).getEnd();
                count++;
            }
        }
        System.out.print(count);
    }
}
