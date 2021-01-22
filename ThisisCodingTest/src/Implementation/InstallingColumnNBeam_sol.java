package Implementation;

// 이것이 코딩 테스트다.
// Chapter 12 : 구현 기출 6 기둥과 보 설치 해답
// 프로그래머스 2020 카카오 신입 공채 (level 3)
// https://programmers.co.kr/learn/courses/30/lessons/60061

// 설치하거나 삭제할 수 있는 경우의 수를 모두 따지기 보다 우선 설치/삭제를 한 후 가능한지 확인하는 방법
// ArrayList<ArrayList<Integer>>에 저장한 후, ArrayList<Node>에 담아 정렬
// 정렬 한 후 이차원 배열 형태로 변환

import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node>{
    int x;
    int y;
    int thing;

    public Node(int x, int y, int thing){
        this.x = x;
        this.y = y;
        this.thing = thing;
    }

    @Override
    public int compareTo(Node o) {
        if(this.x==o.x && this.y == o.y) return Integer.compare(this.thing, o.thing);
        if(this.x == o.x) return Integer.compare(this.y , o.y);
        return Integer.compare(this.x, o.x);
    }
}

public class InstallingColumnNBeam_sol {
    public static boolean possible(ArrayList<ArrayList<Integer>> answer){
        for(int i = 0; i < answer.size(); i++){
            int x = answer.get(i).get(0);
            int y = answer.get(i).get(1);
            int thing = answer.get(i).get(2);
            //기둥인 경우
            if(thing == 0){
                boolean check = false;
                //바닥 위라면 true
                if(y == 0) check = true;
                //다른 기둥 위 or 보의 한 쪽 끝 부분 위
                for(int j = 0; j < answer.size(); j++){
                    //보가 왼쪽에 있는 경우
                    if(x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) check = true;
                    //보가 오른쪽에 있는 경우
                    if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) check = true;
                    //다른 기둥 위
                    if(x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) check = true;
                }
                if(!check) return false;
            }
            //보인 경우
            else if(thing == 1){
                boolean check = false;
                boolean left = false;
                boolean right = false;
                //한쪽 끝 부분이 기둥 위 or 양쪽 끝 부분이 다른 보와 동시에 연결이라면 정상
                for(int j = 0; j < answer.size(); j++){
                    //왼쪽 끝 부분이 기둥 위
                    if(x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) &&  0 == answer.get(j).get(2)) check = true;
                    //오른쪽 끝 부분이 기둥 위
                    if(x + 1 == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) &&  0 == answer.get(j).get(2)) check = true;
                    //왼쪽이 다른 보와 연결
                    if(x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) left = true;
                    //오른쪽이 다른 보와 연결
                    if(x + 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) right = true;
                }
                if(left && right) check = true;
                if(!check) return false;
            }
        }
        return true;
    }
    public static int[][] solution(int n, int[][] build_frame) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int thing = build_frame[i][2];
            int operate = build_frame[i][3];

            //삭제 연산이면
            if(operate == 0){
                int index = 0;
                for(int j = 0; j < answer.size(); j++){
                    //삭제할 것의 인덱스를 저장해둠
                    if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && thing == answer.get(j).get(2)){
                        index = j;
                    }
                }
                //인덱스를 저장하여 delete라는 이름의 데이터를 저장해둠
                ArrayList<Integer> delete = answer.get(index);
                //삭제 함
                answer.remove(index);
                //삭제가 불가능 하다면 다시 추가, 가능하다면 그대로 진행
                if(!possible(answer)){
                    answer.add(delete);
                }
            }
            //설치 연산이면
            if(operate == 1){
                //설치할 데이터를 추가해봄
                ArrayList<Integer> add = new ArrayList<>();
                add.add(x);
                add.add(y);
                add.add(thing);
                answer.add(add);
                //불가능 하다면 마지막에 추가한 데이터 제거
                if(!possible(answer)){
                    answer.remove(answer.size()-1);
                }
            }
        }

        //answer에 담겨있는 정보들을 Node화 해서 저장
        ArrayList<Node> result = new ArrayList<>();
        for(int i = 0; i < answer.size(); i++){
            result.add(new Node(answer.get(i).get(0),answer.get(i).get(1),answer.get(i).get(2)));
        }

        //정렬
        Collections.sort(result);

        //2차원 배열로 변환하여 반환
        int[][] res = new int[result.size()][3];
        for(int i = 0; i < result.size(); i++){
            res[i][0] = result.get(i).x;
            res[i][1] = result.get(i).y;
            res[i][2] = result.get(i).thing;
        }
        return res;
    }

    public static void main(String args[]){
        //int[][] answer = solution(5, new int[][] {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}});
        int[][] answer = solution(5, new int[][] {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}});
        System.out.print("[");
        for(int i = 0; i < answer.length; i++){
            System.out.print("[");
            for(int j = 0; j < answer[0].length; j++){
                System.out.print(answer[i][j] + ",");
            }
            System.out.print("]");
        }
        System.out.print("]");
    }
}
