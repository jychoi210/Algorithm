package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 10 : 그래프 이론 문제 3 커리큘럼

// 1. 진입차수가 0인 노드를 큐에 넣음 
// 2. 큐가 빌 때 까지 다음의 과정을 반복
//  2.1 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거
//  2.2 새롭게 진입차수가 0이 된 노드를 큐에 넣음

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Curriculum {
    public static int n;
    public static int[] time = new int[100001];
    public static int[] indegree = new int[100001];
    public static int[] result = new int[100001];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void topolotySort(){
        //큐 생성
        Queue<Integer> q = new LinkedList<>();

        //result에 각 강의 시간 저장
        for(int i = 1; i < n + 1; i++){
            result[i] = time[i];
        }

        //진입 차수가 0인 노드를 큐에 삽입
        for(int i = 1; i < n + 1; i++){
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        //큐가 빌 때 까지 반복
        while(!q.isEmpty()){
            //큐에서 노드 하나 꺼냄
            int now = q.poll();
            //그 노드와 인접한 노드들에 대하여 진입 차수 감소
            for(int i = 0; i < graph.get(now).size(); i++){
                indegree[graph.get(now).get(i)] -= 1;
                //(현재 선택된 강의 시간 + 그 다음에 들어야 하는 강의 시간), (다음에 들어야 하는 강의까지의 최소 시간)을 비교하여 큰 것을 선택
                //1번강의가 30시간, 2번 강의가 20시간, 3번 강의가 40시간 이라면 (1번 강의 + 3번 강의), (2번 강의 + 3번 강의)의 시간을 비교하는 셈
                result[graph.get(now).get(i)] = Math.max(result[now] + time[graph.get(now).get(i)], result[graph.get(now).get(i)]);
                //진입차수가 0이 된 노드를 다시 큐에 삽입
                if(indegree[graph.get(now).get(i)] == 0){
                    q.offer(graph.get(now).get(i));
                }

            }

        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        //그래프 초기화
        for(int i =0; i < n + 1; i++){
            graph.add(new ArrayList<Integer>());
        }

        //시간과 선수 강의들 번호 입력 받기
        for(int i = 1; i < n + 1; i++){
            int t = sc.nextInt();
            time[i] = t;
            while(true){
                int z = sc.nextInt();
                if(z == -1) break;
                graph.get(z).add(i);
                indegree[i]++;
            }
        }

        //위상 정렬 수행
        topolotySort();

        //값 출력
        for(int i = 1; i < n+1; i++){
            System.out.println(result[i]);
        }

    }
}
