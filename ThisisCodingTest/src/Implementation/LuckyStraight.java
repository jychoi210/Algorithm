package Implementation;

// 이것이 코딩 테스트다.
// Chapter 12 : 구현 기출 1 럭키 스트레이트
// 짝수 자릿수의 수가 입력되면, 반을 잘라 앞의 각 자리 수의 합과 뒤의 각 자라 수의 합이 같다면 LUCKY 출력 아니라면 READY 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyStraight {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        //왼쪽 값과 오른쪽 값 저장할 변수
        int left = 0;
        int right = 0;
        //각 자리수 더해서 저장
        for(int i = 0; i < n.length()/2; i++){
            left += Integer.parseInt(String.valueOf(n.charAt(i)));
            right += Integer.parseInt(String.valueOf(n.charAt(i+n.length()/2)));
        }

        //같다면 LUCKY를 다르다면 READY를 출력
        System.out.print(left == right ? "LUCKY" : "READY");
    }
}
