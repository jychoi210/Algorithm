//https://www.acmicpc.net/problem/1920
// 백준 수 찾기 1920
//N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

import java.util.Arrays;
import java.util.Scanner;



public class bj_binarySearch1{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int i = 0;

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        n = sc.nextInt();
        int[] arr2 = new int[n];
        for(i = 0; i < n; i++){
            arr2[i] = sc.nextInt();
        }

        for(i = 0; i < n; i++){
            binarySearch(arr,arr2[i]);
        }
    }


    public static void binarySearch(int[] arr, int searchValue){
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while(end >= start){
            mid = (start + end) / 2;
            if(arr[mid]==searchValue){
                System.out.println(1);
                return ;
            }
            else if(arr[mid] > searchValue) end = mid - 1;
            else start = mid + 1;
        }
        System.out.println(0);
        return ;
    }
}