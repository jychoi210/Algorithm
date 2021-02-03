package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 18 : 그래프 이론 기출 2 탑승구 해답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gate_sol {
    public static int g,p;
    public static int[] parent = new int[100001];

    //해당 나라의 부모를 찾는 함수
    public static int findParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    //해당 부모 중 값이 작은 것을 새 부모로 설정
    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());

        //부모테이블 자기 자신으로 초기화
        for (int i = 1; i <= g; i++) {
            parent[i] = i;
        }

        int result = 0;
        for(int i = 0; i < p; i++){
            //비행기의 탑승구를 입력 받음
            int x = Integer.parseInt(br.readLine());
            //해당 비행기 탑승구의 root를 구함
            int root = findParent(x);
            //root가 0이면 비행기 도킹이 불가능하므로 break
            if(root == 0) break;
            //root가 0이 아니라면 루트 왼쪽 옆의 것과 union하기
            union(root, root-1);
            result++;
        }
        System.out.print(result);
    }
}
