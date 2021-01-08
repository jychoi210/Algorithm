package Sorting;

// 이것이 코딩 테스트다.
// Chapter 6 : 정렬 예제 1 선택 정렬

public class SelectionSort {

    public static void selectionSort(int[] arr){
        int size = arr.length;
        int temp, mindex;

        for(int i = 0; i < size; i++){
            //현재 원소의 인덱스를 mindex에 저장
            mindex = i;
            for(int j = i + 1; j < size; j++){
                //가장 작은 원소의 인덱스 찾기
                if(arr[mindex] > arr[j]){
                    mindex = j;
                }
            }
            //맨 앞 원소와 가장 작은 원소와 교환
            temp = arr[i];
            arr[i] = arr[mindex];
            arr[mindex] = temp;
        }
    }
    public static void main(String args[]){
        int arr[] = {7, 2, 5, 9, 6, 1, 3, 8, 4};
        selectionSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

}
