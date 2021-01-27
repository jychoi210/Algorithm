package BinarySearch;

// 이것이 코딩 테스트다.
// Chapter 15 : 이진 탐색 기출 2 고정점 찾기
// Amazon Interview

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindingFixedPoint {
    // 고정점 찾는 함수
    public static int findFixedPoint(int[] arr, int start, int end){
        // 모든 탐색 후 없다면 -1 반환
        if(start > end) return -1;
        // mid 값은 시작점과 끝 점의 중간
        int mid = (start + end) / 2;
        // 수열의 인덱스 값과 데이터 값이 같다면 그 값을 리턴
        if(arr[mid] == mid) return mid;
        // 인덱스 값이 더 크면 오른쪽 부분에서 다시 찾기
        else if(arr[mid] < mid) return findFixedPoint(arr,mid + 1, end);
        // 인덱스 값이 작으면 왼쪽 부분에서 다시 찾기
        else return findFixedPoint(arr, start, mid - 1);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열의 개수 n 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 수열 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(findFixedPoint(arr, 0, n-1));

    }
}
