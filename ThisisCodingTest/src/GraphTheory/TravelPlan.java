package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 18 : 그래프 이론 기출 1 여행 계획

//m을 활용하지 않음, 불필요한 for문을 줄여야 함.
//q를 사용하지 말고 정보를 입력 받을 때 바로 union하면 됨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TravelPlan {
    //각 나라의 부모 정보를 담을 배열
    public static int[] parent = new int[501];
    //여행지 수 N, 여행 계획에 속한 도시의 수 m
    public static int n, m;

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
        //여행 계획 나라들을 담을 큐
        Queue<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //여행지 개수 n, 여행 계획 도시 개수 m
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //자기 자신으로 부모 테이블 초기화
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        //여행지가 서로 연결되어 있으면 q에 넣음
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 1 && i < j){
                    q.offer(i+1);
                    q.offer(j+1);
                }
            }
        }

        //q가 빌 때 까지 연결된 나라들 연합함
        while(!q.isEmpty()){
            int x = q.poll();
            int y = q.poll();
            if(findParent(x) != findParent(y)){
                union(x,y);
            }
        }

        boolean check = true;
        String[] temp = br.readLine().split(" ");
        //여행계획의 처음 나라 부모를 찾음
        int result = findParent(Integer.parseInt(temp[0]));
        //모든 여행 계획의 부모들이 같다면 true, 아니라면 false
        for(int i = 1; i < temp.length; i++){
            int x = Integer.parseInt(temp[i]);
            if(result != findParent(x)) check = false;
        }

        //true면 YES, false면 NO 출력
        System.out.print(check ? "YES" : "NO");

    }

}
