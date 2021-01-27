package BinarySearch;

// 이것이 코딩 테스트다.
// Chapter 15 : 이진 탐색 기출 1 정렬된 배열에서 특정 수의 개수 구하기
// Zoho Interview
// 선형탐색으로는 시간초과 판정 --> 데이터가 정렬되어 있기 때문에 이진탐색을 수행
// python의 bisect함수 구현하여 이진탐색으로 풀기

import java.util.Scanner;

public class FindingSpecificNum {
    public static int bisect_right(int[] A, int x) {
        return bisect_right(A, x, 0, A.length);
    }

    public static int bisect_right(int[] A, int x, int lo, int hi) {
        //배열의 사이즈를 N에 저장
        int N = A.length;

        //배열이 비었다면 return
        if (N == 0) return 0;

        //시작 인덱스의 데이터가 찾는 값 x보다 크면 lo 반환
        if (x < A[lo]) return lo;

        //마지막 인덱스의 값이 x보다 작으면 hi 반환
        if (x > A[hi - 1]) return hi;

        for (;;) {
            //시작 인덱스 + 1이 끝 인덱스면 lo + 1 리턴
            if (lo + 1 == hi) return lo + 1;

            //mi는 hi와 lo의 중간 값
            int mi = (hi + lo) / 2;
            //만약 A[mi]값이 x보다 크면 hi는 mi
            if (x < A[mi]) hi = mi;
            // x가 A[mi]보다 크거나 같으면 lo는 mi
            else lo = mi;
        }
    }

    public static int bisect_left(int[] A, int x) {
        return bisect_left(A, x, 0, A.length);
    }

    public static int bisect_left(int[] A, int x, int lo, int hi) {
        int N = A.length;
        if (N == 0) {
            return 0;
        }
        if (x < A[lo]) {
            return lo;
        }
        if (x > A[hi - 1]) {
            return hi;
        }
        for (;;) {
            if (lo + 1 == hi) {
                return x == A[lo] ? lo : (lo + 1);
            }
            int mi = (hi + lo) / 2;
            if (x <= A[mi]) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int left = bisect_left(arr, 2);
        int right = bisect_right(arr, 2);

        int result = right - left;

        System.out.print(result == 0 ? -1 : result);
    }
}
