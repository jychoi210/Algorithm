package Implementation;

// 백준 구현 Q2750 수 정렬하기
// https://www.acmicpc.net/problem/2750
// 오름차순으로 정렬하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2750 {
    public static int n;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] sorting = new int[n];

        for(int i = 0; i < n; i++){
            sorting[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(sorting);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(sorting[i]).append("\n");
        }

        System.out.print(sb);
    }
}
