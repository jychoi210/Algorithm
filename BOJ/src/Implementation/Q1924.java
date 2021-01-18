package Implementation;

// 백준 구현 Q1924 2007
//https://www.acmicpc.net/problem/1924
// 2007년 x월 y일 요일 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1924 {
    public static ArrayList<String> day = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        day.add("SUN");
        day.add("MON");
        day.add("TUE");
        day.add("WED");
        day.add("THU");
        day.add("FRI");
        day.add("SAT");

        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};

        if(x > 1){
            for(int i = 0; i < x - 1; i++){
                y += month[i];
            }
        }
        int d = y / 7;
        y = y - (d * 7);
        System.out.print(day.get(y));

    }
}
