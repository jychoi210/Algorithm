package Greedy;

// 이것이 코딩 테스트다.
// Chapter 11 : 그리디 기출 4 만들 수 없는 금액
// 화폐 단위로 만들 수 없는 금액 중 최솟값 구하기

import java.util.Arrays;
import java.util.Scanner;

public class AmountNotAvailable {
    public final static int INF = (int) 1e9;
    public static int[] available = new int[1000001];

    //조합 합수
    public static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
        //r이 0이면 sum 함수 호출 후 리턴
        if (r == 0) {
            sum(arr, visited, n);
            return;
        }

        //depth가 r이면 반환
        if (depth == n) {
            return;
        }

        //현재 인덱스인 depth를 뽑는다면
        visited[depth] = true;
        //nCr-1 , depth+1 에 대해 재귀적으로 반복
        comb(arr, visited, depth + 1, n, r - 1);
        //현재 인덱스인 depth를 뽑지 않는다면
        visited[depth] = false;
        //nCr, depth+1에 대해 재귀적으로 반복
        comb(arr, visited, depth + 1, n, r);
    }

    //각 조합을 다 더한 후 available 인덱스에 표시
    public static void sum(int[] arr, boolean[] visited, int n) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true) {
                sum += arr[i];
            }
        }
        available[sum] = 1;

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] money = new int[n];
        boolean[] visited = new boolean[money.length];

        for(int i = 0; i < n; i++){
            money[i] = sc.nextInt();
        }

        //money 화폐단위 정렬
        Arrays.sort(money);
        //available을 INF로 초기화
        Arrays.fill(available, INF);

        //nC1부터 nC5까지 조합 진행
        for(int i = 1; i <= n; i++){
            comb(money, visited, 0, 5,i);
        }

        //available이 처음 1이 아닌 INF값을 갖는 index 구하기
        int index = 1;
        while(true){
            if(available[index] == INF){
                break;
            }
            index++;
        }

        System.out.print(index);
    }
}
