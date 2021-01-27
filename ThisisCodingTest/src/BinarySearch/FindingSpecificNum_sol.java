package BinarySearch;

// 이것이 코딩 테스트다.
// Chapter 15 : 이진 탐색 기출 1 정렬된 배열에서 특정 수의 개수 구하기
// Zoho Interview

import java.util.Scanner;

public class FindingSpecificNum_sol {
    //mid값이 target보다 크거나 같다면 end = mid로 설정
    //min값이 target보다 작으면 start를 mid+1로 설정
    //첫 인덱스 찾기
    public static int findNum_left(int[] arr, int start, int end, int target){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] >= target) end = mid;
            else start= mid + 1;
        }
        return end;
    }
    //mid값이 target보다 크다면 end = mid로 설정
    //min값이 target와 같거나 작으면 start를 mid+1로 설정
    //마지막 인덱스 찾기
    public static int findNum_right(int[] arr, int start, int end, int target){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] > target) end = mid;
            else start= mid + 1;
        }
        return end;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //n, x 입력 받기
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];

        //배열 입력 받기
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int a = findNum_left(arr,0,n-1,x);
        int b = findNum_right(arr,0,n-1,x);
        System.out.print(b-a == 0 ? -1 : b-a);
    }
}
