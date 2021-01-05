package Implementation;

// 이것이 코딩 테스트다.
// 구현 예제 04-2 시각

import java.util.Scanner;

public class Time {
    public static boolean check(int h, int m, int s){
        if(h % 10 == 3 || m % 10 == 3 || m / 10 == 3 || s % 10 == 3 || s / 10 == 3) return true;
        return false;
    }

    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        for(int i = 0; i <= n; i++){
            for(int m = 0; m < 60; m++){
                for(int s = 0; s < 60; s++){
                    if(check(i, m, s)) result++;
                }
            }
        }

        //너무 경우의 수로 계산함 ^^..
        /*
        if(n > 3){
            result = n * (10*6*10 + 5*6*10 + 5*9*10 + 5*9*5) + 6*10*6*10;
        }else{
            result = (n + 1) * (10*6*10 + 5*6*10 + 5*9*10 + 5*9*5);
        }
        */

        System.out.print(result);

    }
}
