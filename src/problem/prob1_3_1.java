package problem;

// 문자열에 들어가는 모든 공백을 '%20'으로 바꿔주는 메서드 작성
// 충분한 공간이 확보되어 있으며, 최종 길이가 함께 주어진다고 가정해도 된다.
// Java로 구현할 경우, 배열 안에서 작업할 수 있도록 문자배열을 사용하길 권장

// idea 1
// 문자열을 입력받아 char배열에 넣은 후, 공백 수를 세어 결과 배열의 크기를 지정한다.
// 공백일 경우 '%', '2', '0' 을 각각 추가하여 결과 배열을 만든다.

/* 입력은 알파벳으로 주었다고 가정하였습니다. 문자열의 최종 길이 또한 함께 주어진다고 가정했습니다. */

import java.util.Scanner;

public class prob1_3_1 {
    public static void main(String args[]){
        String inputChar;
        int inputNum;
        Scanner sc = new Scanner(System.in);
        inputChar = sc.nextLine();
        inputNum = sc.nextInt();

        char[] original = inputChar.toCharArray();
        System.out.println(replaceURL(inputNum, original));

    }
    public static int count(char[] original){
        int countNum = 0;
        for(char temp : original){
            if(temp == ' '){
                countNum++;
            }
        }
        return countNum;
    }
    public static char[] replaceURL(int num, char[] original){
        int spaceNum = count(original);
        char[] result = new char[num+spaceNum*2];
        int i = 0;
        for(char temp : original){
            if(temp == ' '){
                result[i] = '%';
                i++;
                result[i] = '2';
                i++;
                result[i] = '0';
                i++;
            }
            else{
                result[i] = temp;
                i++;
            }
        }

        return result;
    }
}
