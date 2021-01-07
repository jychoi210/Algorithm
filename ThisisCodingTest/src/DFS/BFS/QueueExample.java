package DFS.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String args[]){
        Queue<Integer> q = new LinkedList<>();

        q.offer(5);
        q.offer(2);
        q.offer(3);
        q.offer(7);
        q.poll();
        q.offer(1);
        q.offer(4);
        q.poll();

        //큐에 먼저 들어온 원소부터 출력
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
