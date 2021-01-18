package Greedy;

// 이것이 코딩 테스트다.
// Chapter 11 : 그리디 기출 6 무지의 먹방 라이브
// 프로그래머스 2019 카카오 신입 공채 (level 4)
// https://programmers.co.kr/learn/courses/30/lessons/42891

import java.util.LinkedList;
import java.util.Queue;

class Food{
    int num;
    int time;

    public Food(int num, int time){
        this.num = num;
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public int getTime() {
        return time;
    }
}

public class MujisLive {
    public static int solution(int[] food_times, long k) {
        int answer = 0;
        long max = 0;
        Queue<Food> q = new LinkedList<>();
        for(int i = 1; i < food_times.length + 1; i++){
            q.offer(new Food(i,food_times[i - 1]));
            max += food_times[i-1];
        }

        if(max <= k) return -1;

        for(int i = 0; i < k; i++){
            if(q.isEmpty()) {
                answer = -1;
                break;
            }
            Food f = q.poll();
            if(f.time - 1> 0){
                q.offer(new Food(f.getNum(), f.getTime()-1));
            }
        }

        if(q.isEmpty()) answer = -1;
        else answer = q.poll().getNum();

        return answer;
    }
    public static void main(String args[]){
        System.out.print(solution(new int[] {1,1,1}, 5));
    }
}
