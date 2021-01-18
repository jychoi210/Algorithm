package Implementation;

// 백준 구현 Q1110 더하기 사이클
// https://www.acmicpc.net/problem/1110
// N의 사이클 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1110 {
    // 입력받을 수 n과 새로운 수 temp
    public static String n, temp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n 입력 받기
        n = br.readLine();
        //result는 1로 설정
        int result = 1;
        //n이 0이면 result = 1;
        if(n.equals('0')) result = 1;
        //n이 0이 아니라면
        else{
            // 만약 1자리 수라면 뒤에 같은 수를 붙여줌
            // ex) 1 -> 11
            if(Integer.parseInt(n)/10 == 0){
                temp = n + "" + n;
            }
            //한자리 수가 아니라면, 맨 뒤의 숫자와 (앞의 숫자 + 뒤의 숫자)의 1의 자리 수를 붙여 새로운 수를 만듦
            else temp = n.charAt(1) + "" + (((n.charAt(0) - '0') + (n.charAt(1) - '0')) % 10);
            //새로운 수가 n이 될 때 까지 반복
            while(Integer.parseInt(n) != Integer.parseInt(temp)){
                // 만약 1자리 수이고 앞에 0이 없다면 앞에 0을 붙여줌
                if(Integer.parseInt(temp)/10 == 0 && !temp.contains("0")){
                    temp = "0" + temp;
                }
                // 새로운 수는 원래 수의 맨 뒤의 숫자와 (앞의 숫자 + 뒤의 숫자)의 1의 자리 수를 붙여 새로운 수를 만듦
                temp = temp.charAt(1) + "" + (((temp.charAt(0) - '0') + (temp.charAt(1) - '0')) % 10);
                //숫자 세기
                result++;
            }
        }

        System.out.print(result);
    }
}
