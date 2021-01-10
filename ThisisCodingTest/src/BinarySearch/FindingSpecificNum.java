package BinarySearch;

// 이것이 코딩 테스트다.
// Chapter 7 : 이진탐색 문제 3 정렬된 배열에서 특정 수의 개수 구하기
// 선형탐색으로는 시간초과 판정 --> 데이터가 정렬되어 있기 때문에 이진탐색을 수행

import java.util.Scanner;

public class FindingSpecificNum {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            if(arr[i] > max) max = arr[i];
        }

        int[] sort = new int[max+1];

        for(int i = 0; i < n; i++){
            sort[arr[i]]++;
        }

        System.out.print(sort[x] == 0 ? -1 : sort[x]);
    }
}
