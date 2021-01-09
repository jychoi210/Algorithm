package BinarySearch;

// 이것이 코딩 테스트다.
// Chapter 7 : 이진탐색 예제 1 이진탐색(재귀적방법)

import java.util.Scanner;

public class BinarySearch_recursion {
    public static int binarySearch(int[] arr, int start, int end, int target){
        if(start > end) return -1;

        int mid = (start + end) / 2;
        if(arr[mid] > target) return binarySearch(arr, start, mid - 1, target);
        else if(arr[mid] < target) return binarySearch(arr, mid + 1, end, target);
        else return mid;

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(binarySearch(arr,0,n-1,target) == -1 ? "원소가 존재하지 않습니다." : binarySearch(arr,0,n-1,target) + 1);
    }
}
