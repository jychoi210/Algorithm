package Sorting;

// 이것이 코딩 테스트다.
// Chapter 6 : 정렬 예제 3 퀵 정렬

public class QuickSort {
    public static void quicksort(int arr[], int start, int end){
        //start와 end가 같다면, 즉 원소가 1개라면 종료
        if(start >= end) return;
        //첫 번째 원소를 pivot으로 설정
        int pivot = start;
        int left = start + 1;
        int right = end;
        int temp;
        //left가 right보다 작을 때
        while(left <= right){
            //left가 pivot의 값보다 큰 값을 찾을 때 까지 반복
            while(arr[left] <= arr[pivot] && left <= end) left++;
            //right가 pivot의 값보다 작은 값을 찾을 때 까지 반복
            while(arr[right] >= arr[pivot] && right > start) right--;
            //만약 left와 right가 엇갈린 경우, pivot과 작은 값인 right를 교환
            if(left > right){
                temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            }
            // 엇갈리지 않은 경우, 큰 값과 작은 값을 교환
            else{
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        //분할이 끝난 후 왼쪽 부분과 오른쪽 부분에서 각각 퀵정렬 수행
        quicksort(arr, start, right - 1);
        quicksort(arr, right + 1, end);
    }
    public static void main(String args[]){
        int arr[] = {7, 2, 5, 9, 6, 1, 3, 8, 4};
        quicksort(arr, 0, arr.length-1);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
