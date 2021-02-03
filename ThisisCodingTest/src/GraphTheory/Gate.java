package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 18 : 그래프 이론 기출 2 탑승구

//서로소 집합 알고리즘을 사용하지 않음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Gate {
    public static int g,p;
    public static int gate[] = new int[100001];

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //탑승구 개수 g 입력 받기
        g = Integer.parseInt(br.readLine());
        //비행기 개수 p 입력 받기
        p = Integer.parseInt(br.readLine());

        //새로운 비행기를 도킹할 수 있는지 판단할 변수
        boolean check = false;
        //도킹할 수 있는 비행기 최대 개수
        int result = 0;
        //gate를 0으로 초기화
        Arrays.fill(gate, 0);

        //비행기가 도킹할 수 있는 탑승구의 정보 입력 받기
        ArrayList<Integer> plane = new ArrayList<>();
        for(int i = 0; i < p; i++){
            plane.add(Integer.parseInt(br.readLine()));
        }

        //비행기 한개씩 도킹할 수 있는지 판단
        for(int i = 0; i < p; i++){
            check = false;
            int x = plane.get(i);
            //탑승구가 비어있다면 도킹할 수 있는 탑승구에 비행기 도킹
            //탑승구가 비어있지 않다면 왼쪽의 탑승구가 비어있는지 확인 후 비행기 도킹
            for(int j = x; j >= 1 ; j--){
                if(gate[j] == 0){
                    gate[j] = 1;
                    result++;
                    check = true;
                    break;
                }
            }
            //만약 비행기가 도킹할 수 없다면 운행 중지
            if(!check) break;
        }
        System.out.print(result);
    }

}
