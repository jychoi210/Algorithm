package Sorting;

// 이것이 코딩 테스트다.
// Chapter 14 : 정렬 기출 3 실패율
// 프로그래머스 2019 카카오 신입 공채 1차 (level 1)
// https://programmers.co.kr/learn/courses/30/lessons/42889

import java.util.ArrayList;
import java.util.Collections;

//실패율 담을 errorRate 클래스 생성
class errorRate implements Comparable<errorRate>{
    int index;
    double rate;

    public errorRate(int index, double rate){
        this.index = index;
        this.rate = rate;
    }

    @Override
    public int compareTo(errorRate other){
        //실패율이 같다면 스테이지 번호 작은 순서로 정렬
        if(this.rate == other.rate) return this.index < other.index ? -1 : 1;
        // 실패율이 큰 순서로 정렬
        return this.rate > other.rate ? -1 : 1;
    }
}
public class FailureRate {
    public static int[] solution(int n, int[] stages){
        //실패율 리스트 생성
        ArrayList<errorRate> rateArrayList = new ArrayList<>();
        //게임 유저 구하기
        int user = stages.length;
        //각 스테이지에 머물러 있는 유저들 구하기
        int[] result = new int[n];
        for(int i = 0; i < user; i++){
            if(stages[i] <= n) result[stages[i] - 1]++;
        }

        double rate;
        //n개의 단계에 대해서 실패율 구하기
        for(int i = 0; i < n; i++){
            //만약 0이라면 실패율은 0
            if(user == 0 || result[i] == 0) rate = 0;
            //0이 아니라면 실패율 구하기
            else rate = (double) result[i] / user;
            //실패율 리스트에 추가
            rateArrayList.add(new errorRate(i + 1, rate));
            //남은 유저들 갱신
            user -= result[i];
        }

        //실패율 리스트 정렬
        Collections.sort(rateArrayList);

        //배열에 스테이지 번호만 담기
        for(int i = 0; i < n; i++){
            result[i] = rateArrayList.get(i).index;
        }
        //배열 리턴
        return result;
    }
    public static void main(String args[]){
        int[] result = solution(5,new int[]{2,1,2,6,2,4,3,3});
        for(int i : result){
            System.out.print(i +" ");
        }
        System.out.println();

        int[] result2 = solution(4,new int[]{4,4,4,4,4});
        for(int i : result2){
            System.out.print(i +" ");
        }
        System.out.println();
    }
}
