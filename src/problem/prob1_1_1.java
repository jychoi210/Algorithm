package problem;

// 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘
// 자료구조 사용하지 않고 풀기
// idea 1
// 입력 받은 문자열의 공백 제거 후, 앞 뒤로 글자가 같은지 확인한다.
// 문자열 길이가 N이라면, 시간 복잡도는 O(N)이다.

/* 입력은 유니코드, 알파벳으로 가정한다. */

import java.util.Arrays;
import java.util.Scanner;

public class prob1_1_1 {
    public static void main(String args[]){
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        Boolean check=false;

        String[] A;

        s = s.replace(" ","");
        A = s.split("");

        Arrays.sort(A);
        for(int i = 0; i < A.length - 1; i++){
            if(A[i].equals(A[i+1])){
                check = true;
                break;
            }
        }
        System.out.print(""+check);

    }
}
