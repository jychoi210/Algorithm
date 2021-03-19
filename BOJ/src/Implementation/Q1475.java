package Implementation;

// 백준 구현 Q1475 방 번호
// https://www.acmicpc.net/problem/1475
// 플라스틱 숫자 세트 최소 구매 개수

import java.io.*;
import java.util.*;

public class Q1475 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split("");
        int[] nums = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
        int[] num = new int[10];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 9){
                num[6]++;
            }else{
                num[nums[i]]++;
            }
        }
        int result = 0;
        for(int i = 0; i < 10; i++){
            if(i == 6){
                if(num[i] % 2 == 0) result = Math.max(result, num[i] / 2);
                else result = Math.max(result, num[i] / 2 + 1);
            }else{
                result = Math.max(result, num[i]);
            }
        }
        System.out.print(result);

    }
}
