package Greedy;

// 이것이 코딩 테스트다.
// Chapter 11 : 그리디 기출 1 모험가 길드

import java.util.Arrays;
import java.util.Scanner;

public class AdventurerGuild {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] adventurer = new int[n];

        //모험가의 공포도 입력 받기
        for (int i = 0; i < n; i++) {
            adventurer[i] = sc.nextInt();
        }

        Arrays.sort(adventurer);

        //그룹 수와 팀원 수 저장
        int group = 0;
        int teamNum = 1;

        for (int i = 0; i < n; i++) {
            //팀원 수가 공포도보다 크거나 같으면 그룹 하나 생성, 팀원 1로 초기화
            if (teamNum >= adventurer[i]) {
                group++;
                teamNum = 1;
            }
            //팀원 수가 공포도보다 작다면 팀원 수만 1 증가
            else {
                teamNum++;
            }
        }

        System.out.print(group);
    }
}

