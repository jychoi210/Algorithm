package DynamicProgramming;

// 이것이 코딩 테스트다.
// Chapter 16 : 다이나믹 프로그래밍 기출 5 못생긴 수 해답
// Google Interview

import java.util.Scanner;

public class UglyNumber_sol {
    public static int n;
    public static int[] ugly = new int[1000];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        //2배, 3배, 5배를 위한 인덱스
        int x2 = 0, x3 = 0, x5 = 0;
        //비교할 수 들
        int t2 = 2, t3 = 3, t5 = 5;

        //못생긴 수의 첫번째 수는 1
        ugly[0] = 1;
        //1부터 n까지 반복
        for(int i = 1 ; i < n; i++){
            //t2, t3, t5 중 가장 작은 것을 선택
            ugly[i] = Math.min(t2,Math.min(t3,t5));
            //선택된 수가 t2라면, 2를 곱하는 인덱스 하나 증가
            //ugly[x2]의 인덱스에 2를 곱해서 다음 t2를 만든다.
            //if else가 아닌 if문을 통해 중복 제거
            if(ugly[i] == t2){
                x2++;
                t2 = ugly[x2] * 2;
            }
            if(ugly[i] == t3){
                x3++;
                t3 = ugly[x3] * 3;
            }
            if(ugly[i] == t5){
                x5++;
                t5 = ugly[x5] * 5;
            }
        }
        System.out.print(ugly[n-1] + " ");
    }
}
