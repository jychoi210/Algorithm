package Implementation;

// 이것이 코딩 테스트다.
// 구현 예제 04-1 상하좌우

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UDLR {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] udlr = br.readLine().split(" ");
        //int[] dx = {0, 0, -1, 1};
        //int[] dy = {-1, 0, 1, 1};
        //char[] move = {'U', 'D', 'L', 'R'};

        int x = 1;
        int y = 1;

        //입력받은 문자열을 차례로 확인
        //위치를 벗어나지 않는다면 상하좌우에 맞게 이동
        for(int i = 0; i < udlr.length; i++){
            if(udlr[i].equals("U")){
                if(x != 1) x -= 1;
            }else if(udlr[i].equals("D")){
                if(x != n) x += 1;
            }else if(udlr[i].equals("L")){
                if(y != 1) y -= 1;
            }else{
                if(y != n) y += 1;
            }
        }
        System.out.print(x + " " + y);
    }
}
