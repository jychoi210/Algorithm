package problem;

// 문자열에 들어가는 모든 공백을 '%20'으로 바꿔주는 메서드 작성
// 충분한 공간이 확보되어 있으며, 최종 길이가 함께 주어진다고 가정해도 된다.
// Java로 구현할 경우, 배열 안에서 작업할 수 있도록 문자배열을 사용하길 권장

// idea 2
// char배열을 쓰지 않고, 문자열을 입력받아 replace사용
// 문자열을 입력받아 replace로 변경 후 char배열로 변환

/* 입력은 알파벳으로 주었다고 가정하였습니다. 문자열의 최종 길이 또한 함께 주어진다고 가정했습니다. */

import java.util.Scanner;

public class prob1_3_2 {
    public static void main(String args[]){
        String inputChar, result, result2;
        Scanner sc = new Scanner(System.in);
        inputChar = sc.nextLine();

        result = inputChar.replace(" ","%20");
        result2 = inputChar.replace(" ","%20");

        result2.toCharArray();

        System.out.println(result);
        System.out.println(result2);

    }
}
