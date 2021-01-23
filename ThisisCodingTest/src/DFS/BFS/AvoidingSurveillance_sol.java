package DFS.BFS;

// 이것이 코딩 테스트다.
// Chapter 13 : DFS, BFS 기출 6 감시 피하기 해답
// https://www.acmicpc.net/problem/18428

import java.util.ArrayList;
import java.util.Scanner;

class Combination {
    private int n;
    private int r;
    private int[] now; // 현재 조합
    private ArrayList<ArrayList<Position>> result; // 모든 조합

    public ArrayList<ArrayList<Position>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position>>();
    }

    public void combination(ArrayList<Position> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class AvoidingSurveillance_sol {
    public static int n;
    public static ArrayList<Position> teachers = new ArrayList<>();
    public static ArrayList<Position> spaces = new ArrayList<>();
    public static char[][] hallway = new char[6][6];

    public static boolean surveillance(int x, int y, int d){
        if(d == 0) {
            for (int i = x; i < n; i++) {
                if (hallway[i][y] == 'S') return true;
                if (hallway[i][y] == 'O') return false;
            }
        }
        if(d == 1) {
            for (int i = x; i >= 0; i--) {
                if (hallway[i][y] == 'S') return true;
                if (hallway[i][y] == 'O') return false;
            }
        }
        if(d == 2) {
            for (int i = y; i < n; i++) {
                if (hallway[x][i] == 'S') return true;
                if (hallway[x][i] == 'O') return false;
            }
        }
        if(d == 3) {
            for (int i = y; i >= 0; i--) {
                if (hallway[x][i] == 'S') return true;
                if (hallway[x][i] == 'O') return false;
            }
        }
        return false;
    }
    // 장애물 설치 이후에, 한 명이라도 학생이 감지되는지 검사
    public static boolean process() {
        // 모든 선생의 위치를 하나씩 확인
        for (int i = 0; i < teachers.size(); i++) {
            int x = teachers.get(i).getX();
            int y = teachers.get(i).getY();
            // 4가지 방향으로 학생을 감지할 수 있는지 확인
            for (int j = 0; j < 4; j++) {
                if (surveillance(x, y, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hallway[i][j] = sc.next().charAt(0);
                // 선생님이 존재하는 위치 저장
                if (hallway[i][j] == 'T') {
                    teachers.add(new Position(i, j));
                }
                // 장애물을 설치할 수 있는 (빈 공간) 위치 저장
                if (hallway[i][j] == 'X') {
                    spaces.add(new Position(i, j));
                }
            }
        }

        // 빈 공간에서 3개를 뽑는 모든 조합을 확인
        Combination comb = new Combination(spaces.size(), 3);
        comb.combination(spaces, 0, 0, 0);
        ArrayList<ArrayList<Position>> spaceList = comb.getResult();

        // 학생이 한 명도 감지되지 않도록 설치할 수 있는지의 여부
        boolean found = false;
        for (int i = 0; i < spaceList.size(); i++) {
            // 장애물들을 설치해보기
            for (int j = 0; j < spaceList.get(i).size(); j++) {
                int x = spaceList.get(i).get(j).getX();
                int y = spaceList.get(i).get(j).getY();
                hallway[x][y] = 'O';
            }
            // 학생이 한 명도 감지되지 않는 경우
            if (!process()) {
                // 원하는 경우를 발견한 것임
                found = true;
                break;
            }
            // 설치된 장애물을 다시 없애기
            for (int j = 0; j < spaceList.get(i).size(); j++) {
                int x = spaceList.get(i).get(j).getX();
                int y = spaceList.get(i).get(j).getY();
                hallway[x][y] = 'X';
            }
        }

        if (found) System.out.println("YES");
        else System.out.println("NO");
    }
}
