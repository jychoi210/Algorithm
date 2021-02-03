package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 18 : 그래프 이론 기출 1 여행 계획 해답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TravelPlan_sol {
    public static int[] parent = new int[501];
    public static int n, m;

    public static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //n, m 입력 받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //부모 테이블을 자기 자신으로 초기화
        for(int i  = 0; i <= n; i++){
            parent[i] = i;
        }

        //정보를 입력 받아 1인 경우(양방향 통로가 있는 경우) union 진행
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int x = Integer.parseInt(st.nextToken());
                if(x == 1 && i > j){
                    union(i+1, j+1);
                }
            }
        }

        boolean check = true;
        st = new StringTokenizer(br.readLine());
        //여행계획의 처음 나라 부모를 찾음
        int x = findParent(Integer.parseInt(st.nextToken()));
        //모든 여행 계획의 부모들이 같다면 true, 아니라면 false
        for(int i = 1; i < m; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(x != findParent(tmp)) check = false;

        }

        //true면 YES, false면 NO 출력
        System.out.print(check ? "YES" : "NO");
    }
}
