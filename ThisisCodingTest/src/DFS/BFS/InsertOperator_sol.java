package DFS.BFS;

// 이것이 코딩 테스트다.
// Chapter 13 : DFS, BFS 기출 5 연산자 끼워넣기 해답
// https://www.acmicpc.net/problem/14888

//dfs로 풀기
//완전탐색보다 메모리 1/5 , 시간 1/10

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InsertOperator_sol {
    //수의 개수
    public static int n;
    //수열 리스트
    public static ArrayList<Integer> num = new ArrayList<>();
    //더하기, 빼기, 곱하기, 나누기 연산자 개수
    public static int add, sub, mul, div;

    //최솟값, 최댓값 초기화
    public static int min = (int)1e9;
    public static int max = (int)-1e9;

    //dfs 연산 (i번째, 현재까지 계산한 값)
    public static void dfs(int i, int now) {
        //모든 연산자를 다 사용한 경우, 최솟값과 최댓값 갱신
        if(i == n){
            min = Math.min(min, now);
            max = Math.max(max, now);
        }
        else{
            //각 연산자에 대해 재귀적으로 수행
            if(add > 0){
                //add 연산자 개수 줄인 후 dfs 수행
                add -= 1;
                dfs(i+1,now + num.get(i));
                //다시 add 연산자 개수 늘림
                add += 1;
            }
            if(sub > 0){
                sub -= 1;
                dfs(i + 1, now - num.get(i));
                sub += 1;
            }
            if(mul > 0){
                mul -= 1;
                dfs(i+1, now * num.get(i));
                mul += 1;
            }
            if(div > 0){
                div -= 1;
                dfs(i+1, now / num.get(i));
                div += 1;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //n 입력 받기
        n = Integer.parseInt(st.nextToken());

        // 수 입력 받기
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            num.add(Integer.parseInt(st.nextToken()));
        }

        //연산자 개수 입력 받기
        st = new StringTokenizer(br.readLine());
        add = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());
        mul = Integer.parseInt(st.nextToken());
        div = Integer.parseInt(st.nextToken());

        // dfs 수행
        dfs(1, num.get(0));

        System.out.println(max);
        System.out.println(min);
    }
}
