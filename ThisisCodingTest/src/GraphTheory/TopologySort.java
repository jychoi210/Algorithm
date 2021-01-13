package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 10 : 그래프 이론 예제 5 위상 정렬

// 1. 진입차수가 0인 노드를 큐에 넣음
// 2. 큐가 빌 때 까지 다음의 과정을 반복
//  2.1 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거
//  2.2 새롭게 진입차수가 0이 된 노드를 큐에 넣음

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologySort {
    // 노드의 개수(V)와 간선의 개수(E)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int v, e;
    public static int[] indegree = new int[100001];
    //알고리즘 수행 결과를 담을 리스트
    public static ArrayList<Integer> result = new ArrayList<>();
    // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    //위상정렬 함수
    public static void topologySort(){
        Queue<Integer> q = new LinkedList<>();

        //진입 차수가 0인 노드를 큐에 삽입
        for(int i = 1; i < v + 1; i++){
            if (indegree[i] == 0) q.offer(i);
        }

        //큐가 빌 때 까지 반복
        while(!q.isEmpty()){
            //큐에서 원소를 꺼냄
            int now = q.poll();
            //result에 꺼낸 노드 삽입
            result.add(now);

            //해당 원소와 연결된 노드들의 진입차수 1 감소
            //만약 진입차수가 0이라면 큐에 삽입
            for(int i = 0; i < graph.get(now).size(); i++){
                indegree[graph.get(now).get(i)] -= 1;
                if(indegree[graph.get(now).get(i)] == 0){
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        //result 출력
        for(int i : result){
            System.out.print(i + " ");
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //v, e 입력 받기
        v = sc.nextInt();
        e = sc.nextInt();

        //그래프 초기화
        for(int i =0; i < v + 1; i++){
            graph.add(new ArrayList<Integer>());
        }

        //간선 정보 입력 받기
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            //도착 노드 b에 진입차수를 1 증가 시킨다.
            indegree[b]+=1;
        }

        //위상 정렬 수행
        topologySort();
    }
}
