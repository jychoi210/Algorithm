package Sorting;

// 이것이 코딩 테스트다.
// Chapter 14 : 정렬 기출 3 실패율 (이전에 풀었던 코드)
// 프로그래머스 2019 카카오 신입 공채 1차 (level 1)
// https://programmers.co.kr/learn/courses/30/lessons/42889

// hashset사용

import java.util.Collections;
import java.util.HashSet;

public class FailureRate_before {
    public static int[] solution(int N, int[] stages){
        //최종 실패율 담을 배열
        int[] answer = new int[N];
        // 게임 플레이어 수
        int[] player = new int[N+2];
        // 게임 클리어한 플레이어 수
        int[] clearPlayer = new int[N+2];
        // 실패율 저장할 배열
        double[] errorRate = new double[N];
        //0단계는 없으므로 0 삽입
        clearPlayer[0] = 0;
        //1단계는 총 게임 플레이어 수
        clearPlayer[1] = stages.length;

        //hashset 만들기
        HashSet<Double> hashSet = new HashSet<>();

        //총 유저 수만큼 반복하여 각 플레이어가 있는 단계에 표시
        for(int i = 0; i < stages.length; i++){
            player[stages[i]]++;
        }

        //게임 클리어한 플레이어 수 구하기
        for(int i = 2; i < player.length; i++){
            clearPlayer[i] = clearPlayer[i-1] - player[i-1];
        }

        //실패율 구하기
        for(int i = 1; i < player.length-1; i++){
            if(player[i] == 0 & clearPlayer[i] == 0){
                errorRate[i-1] = 0;
            }else{
                errorRate[i-1] = (double) player[i] / clearPlayer[i];
            }
            hashSet.add(errorRate[i-1]);
        }

        //hashSet의 사이즈 만큼 반복
        //실패율이 가장 큰 것부터 hashSet에서 꺼낸 후 해당 스테이지 번호를 answer에 순서대로 저장
        int num = hashSet.size();
        int index = 0;
        for(int j = 0; j < num; j++) {
            double max = Collections.max(hashSet);
            for (int i = 0; i < errorRate.length; i++) {
                if (errorRate[i] == max) {
                    answer[index] = i+1;
                    index++;
                }
            }
            hashSet.remove(max);
        }

        return answer;
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
