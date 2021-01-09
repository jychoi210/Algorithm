package BinarySearch;

// 이것이 코딩 테스트다.
// Chapter 7 : 이진탐색 문제 1 부품찾기

import java.util.Scanner;

public class FindParts {
    public static String binarysearch(int[] arr, int start, int end, int part){
        //종료 조건, 못찾았으면 no 출력
        if(start > end) return "no";
        int mid = (start + end) / 2;
        //찾는 부품이 중간 데이터보다 작으면 왼쪽 기준으로 다시 탐색
        if(arr[mid] > part) return binarysearch(arr, start, mid - 1, part);
        //찾는 부품이 중간 데이터보다 크면 오른쪽 기준으로 다시 탐색
        else if(arr[mid] < part) return binarysearch(arr, mid + 1, end, part);
        //찾았다면 yes 리턴
        else return "yes";
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

        //요청한 부품 순서대로 하나씩 찾고 있으면 yes를 없으면 no를 출력
        for(int i = 0; i < m ; i++){
            System.out.print(binarysearch(parts, 0, n-1, request[i]) + " ");
        }
    }
}
