package DFS.BFS;

// 이것이 코딩 테스트다.
// Chapter 13 : DFS, BFS 기출 8 블록 이동하기 해답
// 프로그래머스 2020 카카오 신입 공채 1차 (level 3)
// https://programmers.co.kr/learn/courses/30/lessons/60063

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Robot {
    int x1;
    int y1;
    int x2;
    int y2;
    int distance;

    public Robot(int x1, int y1, int x2, int y2, int distance){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.distance = distance;
    }
}
public class MovingBlocks_sol {
    public static ArrayList<Robot> getNext(Robot pos, int[][] board){
        ArrayList<Robot> next = new ArrayList<Robot>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++){
            //상, 하, 좌, 우로 이동하는 경우
            int x1Next = pos.x1 + dx[i];
            int y1Next = pos.y1 + dy[i];
            int x2Next = pos.x2 + dx[i];
            int y2Next = pos.y2 + dy[i];
            int distNext = pos.distance + 1;
            //이동하고자 하는 두 칸이 모두 비어 있다면
            if(board[x1Next][y1Next] == 0 && board[x2Next][y2Next] == 0){
                next.add(new Robot(x1Next,y1Next,x2Next,y2Next,distNext));
            }
        }

        //가로로 로봇이 놓여 있는 경우
        int[] hor = {-1, 1};
        if(pos.x1 == pos.x2){
            //위쪽으로 회전하는 경우, 아래쪽으로 회전하는 경우
            for(int i = 0; i < 2; i++){
                //위쪽 두칸 또는 아래쪽 두칸이 모두 비어 있다면
                if(board[pos.x1 + hor[i]][pos.y1] == 0 && board[pos.x2 + hor[i]][pos.y2] == 0 ){
                    next.add(new Robot(pos.x1, pos.y1, pos.x1+hor[i], pos.y1, pos.distance + 1));
                    next.add(new Robot(pos.x2, pos.y2, pos.x2+hor[i], pos.y2, pos.distance + 1));
                }
            }
        }
        //세로로 로봇이 놓여 있는 경우
        int[] ver = {-1,1};
        if(pos.y1 == pos.y2){
            //왼쪽으로 회전하거나 오른쪽으로 회전하는 경우
            for(int i = 0; i < 2; i++){
                //왼쪽 두칸 또는 오른쪽 두칸이 모두 비어 있다면
                if(board[pos.x1][pos.y1+ ver[i]] == 0 && board[pos.x2][pos.y2 + ver[i]] == 0 ){
                    next.add(new Robot(pos.x1, pos.y1, pos.x1, pos.y1+ver[i], pos.distance + 1));
                    next.add(new Robot(pos.x2, pos.y2, pos.x2, pos.y2+ver[i], pos.distance + 1));
                }
            }
        }
        //현재 위치에서 이동할 수 있는 위치를 반환
        return next;
    }
    public static int solution(int[][] board){
        int n = board.length;
        //주변에 벽을 한칸씩 더 만듦
        int[][] newBoard = new int[n+2][n+2];
        for(int i = 0; i < n + 2 ; i++){
            for(int j = 0; j < n + 2; j++){
                newBoard[i][j] = 1;
            }
        }

        //가운데에 실제 board값 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i + 1][j + 1] = board[i][j];
            }
        }

        //너비우선탐색 실행
        Queue<Robot> q = new LinkedList<>();
        ArrayList<Robot> visited = new ArrayList<>();
        //처음 시작하는 로봇 위치 설정
        Robot pos = new Robot(1,1,1,2,0);
        //처음 위치 큐에 삽입
        q.offer(pos);
        //방문 처리
        visited.add(pos);

        //큐가 빌 때 까지 반복
        while(!q.isEmpty()){
            pos = q.poll();
            //(n,n)위치에 도달했다면 최단 거리이므로 반환
            if((pos.x1 == n && pos.y1 == n) || (pos.x2 == n && pos.y2 == n)){
                return pos.distance;
            }
            //다음에 움직일 수 있는 위치값 받기
            ArrayList<Robot> nextPos = getNext(pos, newBoard);
            //갈 수 있는 곳 모두 탐색
            for(int i = 0; i < nextPos.size(); i++){
                boolean check = true;
                //갈 수 있는 위치 하나 받음
                pos = nextPos.get(i);
                //방문한 위치라면 break;
                for(int j = 0; j < visited.size(); j++){
                    if(pos.x1 == visited.get(j).x1 && pos.y1 == visited.get(j).y1 && pos.x2 == visited.get(j).x2 && pos.y2 == visited.get(j).y2){
                        check = false;
                        break;
                    }
                }
                //방문하지 않은 위치라면 다음 위치 큐에 삽입하고 방문 처리
                if(check){
                    q.offer(pos);
                    visited.add(pos);
                }
            }
        }
        return 0;
    }
    public static void main(String args[]){
        System.out.print(solution(new int[][] {{0,0,0,1,1},{0,0,0,1,0},{0,1,0,1,1},{1,1,0,0,1},{0,0,0,0,0}}));
    }
}
