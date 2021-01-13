package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 10 : 그래프 이론 예제 2 서로소 집합 (경로 압축 방법 사용)

import java.util.Scanner;

public class DisjointSets_PathCompression {
    //노드 개수 v, 간선의 개수 e
    public static int v, e;
    //노드의 개수는 최대 100,000개로 가정, 부모 테이블 초기화
    public static int[] parent = new int[100001];

    //루트 노드 찾아주는 함수
    //경로 압축 코드를 통해 부모 테이블에 각 노드의 루트 노드를 저장
    public static int findParent(int x){
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    //두 원소가 속한 집합 합치는 합집합 연산
    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        //숫자가 더 작은 것을 부모로 설정
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        //부모를 자기 자신으로 초기화
        for(int i = 1; i <= v; i++){
            parent[i] = i;
        }

        //입력 받은 값으로 union연산 수행
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        System.out.print("각 원소가 속한 집합 : ");
        for(int i = 1; i <= v; i++){
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        System.out.print("부모 테이블 : ");
        for(int i = 1; i <=v; i++){
            System.out.print(parent[i] + " ");
        }
    }
}
