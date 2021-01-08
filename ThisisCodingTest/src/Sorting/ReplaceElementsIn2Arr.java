package Sorting;

// 이것이 코딩 테스트다.
// Chapter 6 : 정렬 문제 3 두 배열의 원소 교체

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReplaceElementsIn2Arr {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N,K 입력받기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //배열 A, B 각각 String 형태로 입력받기
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int A[] = new int[N];
        int B[] = new int[N];

        //배열에 원소 입력
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }

        //배열 A, B 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        //K만큼 반복하며 A의 앞쪽부터 B의 뒤쪽과 비교하며 B가 더 크면 교환
        for(int i = 0; i < K; i++){
            if(A[i] <= B[N-1-i]){
                int temp = A[i];
                A[i] = B[N-1-i];
                B[N-1-i] = temp;
            }
        }

        int result = 0;

        for(int i = 0; i < N; i++){
            result += A[i];
        }

        System.out.print(result);

    }
}
