package Greedy;

// 이것이 코딩 테스트다.
// Chapter 11 : 그리디 기출 4 만들 수 없는 금액 해답
// 화폐 단위로 만들 수 없는 금액 중 최솟값 구하기

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AmountNotAvailable_sol {
    public static int n;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //n 입력 받기
        n = sc.nextInt();

        //arrayList에 각각 동전 단위 입력 받기
        for(int i = 0; i < n; i++){
            arrayList.add(sc.nextInt());
        }

        //동전 정렬 하기
        Collections.sort(arrayList);

        //target = 1로 설정
        int target = 1;
        //현재 1~target-1까지의 모든 금액을 만들 수 있는 상태라고 가정
        //이 때 target인 금액도 만들 수 있는지 확인하는 것임
        //target을 만들 수 있다면 target+현재 금액
        //target이 현재 금액 보다 작다면 break;
        //연속된 수라면 target이 1이므로 총 동전의 합에 + 1 된 값이 나옴
        //연속된 수가 아니라면
        for(int i = 0; i < n; i++){
            if(target < arrayList.get(i)) break;
            target += arrayList.get(i);
        }
    }
}
