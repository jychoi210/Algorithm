package level1;

//프로그래머스 level 1
//2019 카카오 개발자 겨울 인턴십
//크레인 인형뽑기 게임

import java.util.ArrayList;
import java.util.Stack;

public class ClawCraneGame_sol {
    public static int solution(int[][] board, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        //뽑을 인형에 대해 반복
        for(int move : moves){
            for(int j = 0; j < board.length; j++){
                //뽑을 칸을 위에 부터 탐색하여 맨 위의 인형 (처음 0이 아닌 곳)을 찾음
                if(board[j][move - 1] != 0){
                    //stack이 비어있다면 해당 인형 바구니에 넣고 board에 0을 넣음
                    if(stack.isEmpty()){
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    //스택이 비어있지 않다면, 맨 앞의 스택과 현재 인형을 비교하여 같다면
                    if(board[j][move - 1] == stack.peek()){
                        //그 인형 터트림
                        stack.pop();
                        //결과값에 사라진 인형 2개를 더함
                        answer += 2;
                    }
                    //앞의 인형과 해당 인형이 같지 않다면 그냥 스택에 삽입
                    else stack.push(board[j][move - 1]);
                    //해당 인형 자리 0으로 만들고
                    board[j][move-1] = 0;
                    //인형 뽑기 하나 끝냄 (move 하나)
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String args[]){
        System.out.print(solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}));
    }
}
