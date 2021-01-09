package BinarySearch;

// 이것이 코딩 테스트다.
// Chapter 7 : 이진탐색 예제 2 이진탐색(반복적방법)

import java.util.Scanner;

public class BinarySearch_iterative {
    public static int binarysearch(int[] arr, int start, int end, int target){
        while (start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] > target){
                end = mid - 1;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else return mid;
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int result = binarysearch(arr, 0, n-1, target);
        System.out.println(result == -1 ? "원소가 존재하지 않습니다." : result + 1);
    }
}
