package level1;

//프로그래머스 level 1
//2019 카카오 개발자 겨울 인턴십
//크레인 인형뽑기 게임
//https://programmers.co.kr/learn/courses/30/lessons/64061

//리스트 2개 사용하여 비교했으나 stack을 사용하면 더 효과적임

import java.util.ArrayList;

public class ClawCraneGame {
    public static ArrayList<Integer> basket = new ArrayList<>();
    public static int result = 0;
    public static void checkDoll(){
        for(int i = 1; i < basket.size(); i++){
            if(basket.get(i) == basket.get(i-1)){
                basket.remove(i-1);
                basket.remove(i-1);
                result += 2;
            }
        }
    }
    public static int solution(int[][] board, int[] moves){
        //보드 사이즈
        int size = board.length;
        //해당 줄의 남은 인형을 담는 num 리스트
        ArrayList<Integer> num = new ArrayList<>();
        //바구니
        basket = new ArrayList<>();

        //board를 탐색하여 각 줄에 존재하는 인형 개수를 담음
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[j][i] != 0){
                    num.add(size-j);
                    break;
                }
            }
        }

        //move를 반복하며,
        for(int i = 0; i < moves.length; i++){
            //해당 칸에 존재하는 인형이 0이 아니라면
            if(num.get(moves[i]-1) != 0) {
                //바구니에 해당 인형 삽입
                basket.add(board[size - num.get(moves[i]-1)][moves[i]-1]);
                //해당 인형 자리 0으로 만듦
                board[size - num.get(moves[i]-1)][moves[i]-1] = 0;
                //해당 칸에 존재하는 인형에서 1개 빼줌
                num.set(moves[i]-1, num.get(moves[i]-1) - 1);
            }
            //바구니를 검사하여 같은 것이 있다면 터트리기
            checkDoll();
        }
        return result;
    }
    public static void main(String args[]){
        System.out.print(solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}));
    }
}
