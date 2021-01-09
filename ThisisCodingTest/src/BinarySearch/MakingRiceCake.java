package BinarySearch;

// 이것이 코딩 테스트다.
// Chapter 7 : 이진탐색 문제 2 떡볶이 떡 만들기

import java.util.Arrays;
import java.util.Scanner;

public class MakingRiceCake {
    //높이 x대로 자르고 난 후 손님이 가져가는 떡의 양 계산
    public static int sum(int x, int[] arr){
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > x) result += (arr[i] - x);
        }
        return result;
    }
    public static int binarysearch(int[] arr, int start, int end, int m){
        int result = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            //가져가는 떡의 양이 m보다 작으면 오른쪽에서 찾기
            if(sum(mid, arr) < m) end = mid - 1;
            //가져가는 떡의 양이 m보다 크면 왼쪽에서 찾기. 단, 딱 맞아 떨어지지 않을 수 있으니 result에 mid값 저장
            else{
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //n, m 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] length = new int[n];

        //떡의 길이들 입력 받기
        for(int i = 0; i < n; i++){
            length[i] = sc.nextInt();
        }

        //떡 길이 정렬
        Arrays.sort(length);

        //0부터 비교하지 않고, 가장 큰 떡의 길이에서 m을 뺀 길이부터 시작
        System.out.print(binarysearch(length, length[n-1] - m, length[n-1], m));
    }
}
