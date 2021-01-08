package Sorting;

// 이것이 코딩 테스트다.
// Chapter 6 : 정렬 예제 4 계수 정렬

public class CountSort {
    public static void countsort(int arr[]){
        int max = 0;
        //배열에서 가장 큰 값 찾기
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]) max = arr[i];
        }
        //result 배열 생성
        int result[] = new int[max+1];
        //배열의 값에 해당하는 인덱스 값 증가
        for(int i = 0; i < arr.length; i++){
            result[arr[i]]++;
        }
        //result 배열에 저장되어 있는 정렬 정보 출력
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[i]; j++){
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        countsort(arr);
    }
}
