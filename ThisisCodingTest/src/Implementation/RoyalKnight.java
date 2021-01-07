package Implementation;

// 이것이 코딩 테스트다.
// 구현 04-2 왕실의 나이트

import java.util.Scanner;

public class RoyalKnight {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String place = sc.nextLine();
        int result = 0;
        //나이트 이동 경우의 수
        int[][] move = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

        //총 경우의 수인 8개만큼 반복, 이동해서 체스판을 벗어나지 않는다면 count
        for(int i =0; i < 8; i++){
            int x = place.charAt(0);
            int y = place.charAt(1);
            x = x + move[i][0];
            y = y + move[i][1];
            if(x <= 104 && x >= 97 && y <= 56 && y >= 49){
                result++;
            }
        }

        System.out.print(result);

    }
}
