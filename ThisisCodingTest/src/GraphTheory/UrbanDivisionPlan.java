package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 10 : 그래프 이론 문제 2 도시 분할 계획
// 문제는 마을을 2개로 분할할 계획이므로, 2개의 최소 신장 트리가 필요하다.
// 최소 신장 트리를 우선 만들고, 그 중 가장 유지비가 큰 길을 빼면 2개의 최소 신장 트리가 만들어진다.

import java.util.ArrayList; 
import java.util.Collections;
import java.util.Scanner;

//road 클래스 생성, a,b : 집, cost : 길 유지비용
class Road implements Comparable<Road>{
    int a;
    int b;
    int cost;

    public Road(int a, int b, int cost){
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getCost() {
        return cost;
    }

    //비용 작은 것이 우선 순위를 가지도록 설정
    @Override
    public int compareTo(Road o){
        if(this.cost < o.cost) return -1;
        return 1;
    }
}

public class UrbanDivisionPlan {
    //집의 개수 n과 길의 개수 m
    public static int n, m;
    //노드들의 부모테이블 초기화
    public static int[] parent = new int[1000001];
    //길의 정보가 담길 리스트
    public static ArrayList<Road> roads = new ArrayList<Road>();

    //루트 노드 찾는 함수
    public static int findParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    //집을 합치는 함수
    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        //작은 수가 큰 수의 부모가 되도록 설정
        if(a>b) parent[a] = b;
        else parent[b] = a;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //n, m 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();

        //부모 테이블 초기화. 자신의 부모는 자기 자신으로 초기화
        for(int i = 1; i < n + 1; i++ ) parent[i] = i;

        //집 번호와 길의 유지비 입력 받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            roads.add(new Road(a,b,c));
        }

        //길의 비용들을 정렬
        Collections.sort(roads);

        //유지비의 합을 담을 result 변수
        int result = 0;
        //최소신장트리 중 가장 큰 유지비를 저장할 max 변수
        int max = 0;

        //길 모두 탐색하며 싸이클이 생기지 않는다면 합친 후 result에 비용 더함
        for(Road road : roads){
            int a = road.getA();
            int b = road.getB();
            int cost = road.getCost();
            if(findParent(a) != findParent(b)){
                union(a, b);
                result += cost;
                if(max < cost) max = cost;
            }
        }

        //최소신장트리 계산 결과에서 가장 큰 유지비를 뺴주면 2개의 최소신장트리가 된다.
        System.out.print(result - max);

    }
}
