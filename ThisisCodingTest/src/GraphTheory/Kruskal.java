package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 10 : 그래프 이론 예제 4 크루스칼 알고리즘
// 최소 신장 트리를 만드는 데 필요한 비용 계산

// 1. 간선 데이터를 비용에 따라 오름차순으로 정렬
// 2. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는지 확인
//  2.1 사이클이 발생하지 않는 경우 최소 신장 트리에 포함
//  2.2 사이클이 발생하는 경우 최소 신장 트리에 포함X
// 3. 모든 간선에 대하여 2번의 과정 반복

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//간선 클래스 생성, a, b : 간선 끝의 노드 두개 cost : 비용
class Edge implements Comparable<Edge>{
    int a;
    int b;
    int cost;

    public Edge(int a, int b, int cost){
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

    @Override
    public int compareTo(Edge o){
        if(this.cost < o.cost) return -1;
        return 1;
    }
}

public class Kruskal {
    // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int v, e;
    //부모 테이블 초기화
    public static int[] parent = new int[100001];
    // 모든 간선을 담을 리스트
    public static ArrayList<Edge> edges = new ArrayList<>();

    //루트 노드 찾아주는 함수
    //경로 압축 코드를 통해 부모 테이블에 각 노드의 루트 노드를 저장
    public static int findParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    //두 원소가 속한 집합 합치는 합집합 연산
    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        //숫자가 더 작은 것을 부모로 설정
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        //v, e 입력 받기
        v = sc.nextInt();
        e = sc.nextInt();

        //부모 테이블 초기화. 자신의 부모는 자기 자신으로 초기화
        for(int i = 1; i < v + 1; i++ ) parent[i] = i;

        //노드와 비용 입력 받기
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge(a,b,c));
        }

        //간선을 비용순으로 정렬
        Collections.sort(edges);

        // 최소 신장 트리의 비용을 담을 변수
        int result = 0;

        // Edge를 모두 탐색
        for(Edge edge : edges){
            int cost = edge.getCost();
            int a = edge.getA();
            int b = edge.getB();

            //사이클이 발생하지 않는 경우 union을 한 후 최소신장트리에 포함
            if(findParent(a) != findParent(b)){
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.print(result);
    }
}
