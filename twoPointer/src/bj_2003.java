//백준 2003 수들의 합2
//https://www.acmicpc.net/problem/2003
//N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합 A[i]+A[i+1]+…+A[j-1]+A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2003 {
    public static void main(String args[]) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int start = 0;
        int end = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] arr = new int[N];

        st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /*
        for(int i = 0; i < N-1; i++){
            end = i + 1;
            if(arr[i] == M){
                result++;
            }
            int sum = arr[i] + arr[end];
            while(sum < M){
                if(end < N - 1){
                    end++;
                }else{
                    break;
                }
                sum = sum + arr[end];
            }
            if(sum == M){
                result++;
            }

        }
        if(arr[N-1] == M){
            result++;
        }*/
        int sum = 0;

        while(end < N){
            if(sum < M){
                sum += arr[end++];
            }else{
                sum -= arr[start++];
            }

            if(sum == M){
                result++;
            }
        }

        System.out.println(result);

    }
}
