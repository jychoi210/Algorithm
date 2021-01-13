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
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i < n + 1; i++){
            result[i] = time[i];
        }

        for(int i = 1; i < n + 1; i++){
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0; i < graph.get(now).size(); i++){
                indegree[graph.get(now).get(i)] -= 1;
                result[graph.get(now).get(i)] = Math.max(result[now] + time[graph.get(now).get(i)], result[graph.get(now).get(i)]);
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

        topolotySort();

        for(int i = 1; i < n+1; i++){
            System.out.println(result[i]);
        }

    }
}
