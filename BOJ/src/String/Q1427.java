package String;

// 백준 문자열 Q1427 소트인사이드
// https://www.acmicpc.net/problem/1427
// 각 자리의 수 정렬

import java.io.*;
import java.util.*;

public class Q1427 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split("");
        int size = temp.length;
        Integer[] nums = new Integer[size];
        for(int i = 0; i < size; i++){
            nums[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(nums, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i : nums){
            sb.append(i);
        }
        System.out.print(sb.toString());
    }
}
