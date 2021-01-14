package Greedy;

// 이것이 코딩 테스트다.
// Chapter 11 : 그리디 기출 1 모험가 길드 해답

import java.util.ArrayList;
import java.util.Scanner;

public class AdventurerGuild_sol {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //모험가 수 입력 받기
        int n = sc.nextInt();

        //공포도를 입력받을 리스트
        ArrayList<Integer> fearNum = new ArrayList<>();

        //공포도 입력 받기
        for(int i = 0; i < n; i++){
            fearNum.add(sc.nextInt());
        }

        //그룹 수 저장할 변수와 길드 팀원 수를 저장할 변수
        int group = 0;
        int teamNum = 0;

        //팀원 증가한 후 공포도와 비교.
        //팀원 수가 공포도보다 크거나 같으면 group 1 증가, 팀원 0으로 초기화
        for(int i = 0; i < n; i++){
            teamNum += 1;
            if(teamNum >= fearNum.get(i)){
                group++;
                teamNum = 0;
            }
        }

        System.out.print(group);
    }
}
