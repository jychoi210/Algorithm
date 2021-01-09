package BinarySearch;

// 이것이 코딩 테스트다.
// Chapter 7 : 이진탐색 문제 1 부품찾기
// 다른 해답 (계수 정렬) , set 자료형도 사용할 수 있음.

import java.util.Scanner;

public class FindParts_sol {
    //계수 정렬을 활용한 예제
    public static int[] countsort(int[] arr){
        int size = arr.length;
        int max = 0;
        for(int i = 0; i < size; i++){
            if(arr[i] > max) max = arr[i];
        }

        int[] sort = new int[max + 1];

        for(int i = 0; i < arr.length; i++) {
            sort[arr[i]]++;
        }

        return sort;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //가게에 있는 부품 개수와 부품 종류 입력 받기
        int n = sc.nextInt();
        int[] parts = new int[n];
        for(int i = 0; i < n; i++){
            parts[i] = sc.nextInt();
        }

        //손님이 요청한 부품 개수와 부품 종류 입력 받기
        int m = sc.nextInt();
        int[] request = new int[m];
        for(int i = 0; i < m; i++){
            request[i] = sc.nextInt();
        }

        //요청한 부품 순서대로 하나씩 찾고 있으면 yes를 없으면 no를 출력 (계수 정렬)
        for(int i = 0; i < m ; i++){
            if(countsort(parts)[request[i]] != 0) System.out.print("yes ");
            else System.out.print("no ");
        }
    }
}
