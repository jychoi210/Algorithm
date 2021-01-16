package Greedy;

// 이것이 코딩 테스트다.
// Chapter 11 : 그리디 기출 6 무지의 먹방 라이브 해답
// 순차적으로 살피면 효율성 테스트 탈락
// 우선순위 큐를 사용하여 가장 음식량이 적은 것 부터 빼는 방법 적용

import java.util.*;

class Foood implements Comparable<Foood>{
    int num;
    int time;

    public Foood(int num, int time){
        this.num = num;
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Foood other){
        return Integer.compare(this.time, other.time);
    }
}

public class MujisLive_sol {
    public static int solution(int[] food_times, long k) {
        int answer = 0;
        long time = 0;
        PriorityQueue<Foood> pq = new PriorityQueue<>();
        for(int i = 1; i < food_times.length + 1; i++){
            pq.offer(new Foood(i,food_times[i - 1]));
            time += food_times[i-1];
        }

        if(time <= k) return -1;

        time = 0;
        long previous = 0;
        long length = food_times.length;

        while(time + ((pq.peek().getTime() - previous) * length) <= k){
            int now = pq.poll().getTime();
            time += (now - previous) * length;
            length -= 1;
            previous = now;
        }

        ArrayList<Foood> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }

        Collections.sort(result, new Comparator<Foood>() {
            @Override
            public int compare(Foood a, Foood b) {
                return Integer.compare(a.getNum(), b.getNum());

            }
        });

        return result.get((int) ((k - time) % length)).getNum();
    }
    public static void main(String args[]){
        System.out.print(solution(new int[] {3,1,2}, 5));
    }
}
