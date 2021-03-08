package GraphTheory;

// 백준 그래프 이론 Q11724 연결 요소의 개수
// https://www.acmicpc.net/problem/11724
// 방향 없는 그래프가 주어졌을 때, 연결 요소의 개수를 구하는 프로그램을 작성하시오

import java.io.*;
import java.util.*;

public class Q11724 {
    public static int[] parent;

    //부모 찾는 함수
    public static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 합집합 함수
    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a > b) parent[a] = b;
        else parent[b] = a;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //n, m 입력 받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int u, v;

        //parent 배열 생성
        parent = new int[n+1];

        // parent 자기 자신으로 초기화
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        // m개의 간선 개수 입력 받기
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            //u, v 부모가 다르다면 합집합
            if(findParent(u) != findParent(v)) {
                union(u, v);
            }
        }

        int result = 1;
        // 각각의 부모를 다시 찾아줌 (실제 맨 위 부모)
        for(int i = 1; i <= n; i++){
            findParent(i);
        }

        //부모 정렬하기
        Arrays.sort(parent);

        //부모가 다른 집합의 개수 세기
        for(int i = 1; i < n; i++){
            if(parent[i] != parent[i+1]){
                result++;
            }
        }

        //출력
        System.out.print(result);

    }
}
