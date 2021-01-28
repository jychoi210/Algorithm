package BinarySearch;

// 이것이 코딩테스트다.
// Chapter 15 : 이진 탐색 기출 3 공유기 설치 해답
// https://www.acmicpc.net/problem/2110

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class RouterInstallation_sol {
    public static int n, x = 0;
    public static ArrayList<Integer> router = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //n, x 입력 받기
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());


        for(int i = 0; i < n; i++){
            router.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(router);

        //가능한 최소 거리
        int start = 1;
        int end = router.get(n-1) - router.get(0);
        int result = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            int value = router.get(0);
            int count = 1;
            //현재 mid값을 이용해 공유기 설치하기
            for(int i = 1; i < n; i++){
                if(router.get(i) >= value + mid){
                    value = router.get(i);
                    count+=1;
                }
            }
            //X 이상의 공유기를 설치할 수 있는 경우 거리를 1 증가시킴
            if(count >= x){
                start = mid + 1;
                result = mid;
            }
            //X 이상의 공유기를 설치할 수 없는 경우 거리를 1 감소시킴
            else{
                end = mid - 1;
            }
        }
        System.out.print(result);

    }
}
