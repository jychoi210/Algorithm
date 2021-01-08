package Sorting;

// 이것이 코딩 테스트다.
// Chapter 6 : 정렬 예제 2 삽입 정렬

public class InsertionSort {
    public static void insertionSort(int arr[]){
        int temp;
        //1부터 진행
        for(int i  = 1; i < arr.length; i++){
            //i부터 앞자리 수와 비교
            for(int j = i; j > 0; j--){
                //i보다 앞 자리가 더 크다면 교환
                if(arr[j] < arr[j - 1]){
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                // 앞 자리가 작다면 for문 멈춤
                else break;
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {7, 2, 5, 9, 6, 1, 3, 8, 4};
        insertionSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
