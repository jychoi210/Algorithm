package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 10 : 그래프 이론 예제 3 서로소 집합을 활용한 사이클 판별

// 1. 각 간선을 확인하여 두 노드의 루트 노드 확인
//  1.1 루트 노드가 서로 다르면 두 노드에 대해 union연산 수행
//  1.2 루트 노드가 같다면 사이클이 발생한 것
// 2. 그래프에 포함되어 있는 모든 간선에 대하여 1번 과정 반복

import java.util.Scanner;

public class DetermineTheCycle {
    //노드 개수 v, 간선의 개수 e
    public static int v, e;
    //노드의 개수는 최대 100,000개로 가정, 부모 테이블 초기화
    public static int[] parent = new int[100001];

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
        if( a < b ) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String args[]){
        boolean cycle = false;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        //부모 테이블에 각자 자신의 부모를 자기 자신으로 설정
        for(int i = 1; i <= v; i++){
            parent[i] = i;
        }

        //노드를 입력 받아 각 노드의 루트 노드가 서로 다르면 Union 연산 수행
        //같지 않다면 사이클이 발생했으므로, cycle = true
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(findParent(a) != findParent(b)) unionParent(a, b);
            else {
                cycle = true;
                break;
            }
        }

        System.out.print(cycle ? "사이클이 발생했습니다." : "사이클이 발생하지 않았습니다.");
    }
}
