package Implementation;

// 이것이 코딩 테스트다.
// Chapter 12 : 구현 기출 7 치킨 배달 해답
// 삼성전자 SW 역량테스트
// https://www.acmicpc.net/problem/15686

// 치킨집의 크기를 통해 조합을 써도 되는지 판단. 최대 13개이므로 조합 사용 가능
// 조합을 함수가 아닌 Class로 풀기

import java.util.*;

//조합 클래스
class Combination {
    //총 개수 n, 뽑을 개수 r
    private int n;
    private int r;
    private int[] now; // 현재 조합
    private ArrayList<ArrayList<Posi>> result; // 모든 조합

    public ArrayList<ArrayList<Posi>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Posi>>();
    }

    public void combination(ArrayList<Posi> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Posi> temp = new ArrayList<>();
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

class Posi {
    private int x;
    private int y;

    public Posi(int x, int y) {
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

public class ChickenDelivery_sol {
    public static int n, m;
    public static int[][] arr = new int[50][50];
    public static ArrayList<Posi> chicken = new ArrayList<>();
    public static ArrayList<Posi> house = new ArrayList<>();

    public static int getSum(ArrayList<Posi> candidates) {
        int result = 0;
        // 모든 집에 대하여
        for (int i = 0; i < house.size(); i++) {
            int hx = house.get(i).getX();
            int hy = house.get(i).getY();
            // 가장 가까운 치킨 집을 찾기
            int temp = (int) 1e9;
            for (int j = 0; j < candidates.size(); j++) {
                int cx = candidates.get(j).getX();
                int cy = candidates.get(j).getY();
                temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
            }
            // 가장 가까운 치킨 집까지의 거리를 더하기
            result += temp;
        }
        // 치킨 거리의 합 반환
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n, m 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();

        //1이면 집에 추가 2면 치킨집에 추가
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                arr[r][c] = sc.nextInt();
                if (arr[r][c] == 1) house.add(new Posi(r, c)); // 일반 집
                else if (arr[r][c] == 2) chicken.add(new Posi(r, c)); // 치킨집
            }
        }

        // 모든 치킨 집 중에서 m개의 치킨 집을 뽑는 조합 계산
        Combination comb = new Combination(chicken.size(), m);
        comb.combination(chicken, 0, 0, 0);
        //조합을 chickenList에 저장
        ArrayList<ArrayList<Posi>> chickenList = comb.getResult();

        // 치킨 거리의 합의 최소를 찾아 출력
        int result = (int) 1e9;
        for (int i = 0; i < chickenList.size(); i++) {
            result = Math.min(result, getSum(chickenList.get(i)));
        }
        System.out.println(result);
    }
}
