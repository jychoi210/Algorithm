package GraphTheory;

// 백준 그래프이론 Q2606 바이러스
// https://www.acmicpc.net/problem/2606
// 바이러스 걸리는 컴퓨터 수 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2606 {
    public static int n, m, x, y;
    // 부모 테이블 초기화
    public static int[] parent = new int[101];

    // 부모 찾기
    public static int findParent(int x){
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 합집합 연산
    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 컴퓨터 개수와 네트워크 상 연결 개수 정보 입력 받기
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 부모 테이블 자기 자신으로 초기화
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        // 연결 정보 입력 받아 합집합 연산
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        int result = 0;
        // 2부터 n까지 부모를 새로 업데이트 하여, 부모가 1인 것 count
        for(int i = 2; i <= n; i++){
            findParent(i);
            if(parent[i] == 1) result++;
        }
        System.out.print(result);
    }
}
