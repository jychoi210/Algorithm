package Sorting;

// 이것이 코딩 테스트다.
// Chapter 6 : 정렬 문제 1 위에서 아래로

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TopToBottom {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer arr[]= new Integer[N];
        for(int i = 0; i < N; i++){
            sc = new Scanner(System.in);
            arr[i] = sc.nextInt();
        }
        //입력 받은 배열 정렬
        Arrays.sort(arr);
        //역순으로 정렬
        //Arrays.sort(arr, Collections.reverseOrder());

        //거꾸로 출력하는 방법
        for(int i = N - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        //역순으로 정렬하여 출력하는 방법 (리스트로 변환 후 역순으로 정렬, 다시 배열로 변환)
        List<Integer> list = Arrays.asList(arr);
        Collections.reverse(list);
        Integer arr2[] = list.toArray(new Integer[list.size()]);
        for(int i = 0; i < N; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
