package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 18 : 그래프 이론 기출 3 어두운 길

// 크루스칼 알고리즘을 이용하여 최소신장트리를 구하는 전형적 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//도로 양 끝의 집 번호와 도로 거리 정보
class Roadd implements Comparable<Roadd>{
    int a;
    int b;
    int dist;

    public Roadd(int a, int b, int dist){
        this.a = a;
        this.b = b;
        this.dist = dist;
    }

    public int compareTo(Roadd other){
        return Integer.compare(this.dist, other.dist);
    }
}

public class DarkRoad {
    //집의 개수 n, 도로 개수 m
    public static int n, m;
    //부모 테이블
    public static int[] parent = new int[200000];
    //각 도로를 담을 리스트
    public static ArrayList<Roadd> roads = new ArrayList<>();

    //부모 찾는 함수
    public static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    //합치는 함수
    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //n, m 입력 받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //부모 테이블 자기 자신으로 초기화
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        int totalRoad = 0;
        //m개의 도로 정보 입력 받기
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            //총 도로 비용 저장
            totalRoad += c;
            roads.add(new Roadd(a,b,c));
        }

        //도로 거리 짧은 순으로 정렬
        Collections.sort(roads);
        int result = 0;

        for(Roadd road : roads){
            int a = road.a;
            int b = road.b;
            int d = road.dist;

            //싸이클이 발생하지 않으면, 즉 부모가 같지 않으면 합침
            if(findParent(a) != findParent(b)){
                union(a, b);
                //최소신장트리 비용 저장
                result += d;
            }
        }

        //총 도로 거리에서 최소신장트리를 빼면 절약할 수 있는 최대금액
        System.out.print(totalRoad-result);
    }
}
