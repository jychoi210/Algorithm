package DFS.BFS;

// 이것이 코딩 테스트다.
// Chapter 12 : DFS, BFS 기출 3 경쟁적 전염
// https://www.acmicpc.net/problem/18405

// PriorityQueue로 풀면 안됨
// 바이러스 순서가 만약 1초 : 1->2->3 2초 : 1->2->3으로 진행해야 하는데 우선순위 때문에 1->1->2->2->3->-3으로 진행됨
// 몇 초 지났는지 비교하기 위해 Virus 클래스에 second 변수 추가

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 바이러스 위치 x,y와 바이러스 번호 num, 현재 초 second
class Virus implements Comparable<Virus>{
    int x;
    int y;
    int num;
    int second;

    public Virus(int x, int y, int num, int second){
        this.x = x;
        this.y = y;
        this.num = num;
        this.second = second;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getNum() {
        return num;
    }

    public int getSecond() {
        return second;
    }

    //바이러스 번호 작은게 우선순위가 높도록 설정
    @Override
    public int compareTo(Virus v){
        return Integer.compare(this.num,v.num);
    }
}

public class CompetitiveInspection {
    //시험관 크기 n, 바이러스 개수 k, s초 뒤의 x,y 좌표
    public static int n, k, s, x, y;
    //시험관
    public static int[][] examiner;
    //바이러스 정보 담을 queue, 단순 삽입 삭제라면 ArrayDeque가 속도가 더 빠름
    public static Queue<Virus> virus = new ArrayDeque<>();
    //상하좌우를 보기 위한 변수
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    //전염 시키는 함수
    public static void inspection(){
        //virus가 빌 때 까지 반복
        while(!virus.isEmpty()){
            Virus v = virus.poll();
            int cx = v.getX();
            int cy = v.getY();
            int cnum = v.getNum();
            int cs = v.getSecond();
            //현재 지난 초가 s와 같다면 break
            if(cs == s) break;
            //상하좌우 확인
            for (int j = 0; j < 4; j++) {
                //새로 움직일 좌표
                int mx = cx + dx[j];
                int my = cy + dy[j];
                //새로 움직일 좌표가 시험관을 벗어나지 않는다면
                if (mx >= 1 && mx <= n && my >= 1 && my <= n) {
                    //0이라면 전염시킨다.
                    if (examiner[mx][my] == 0) {
                        examiner[mx][my] = cnum;
                        //초를 1 증가하여 virus에 추가
                        virus.offer(new Virus(mx,my,cnum,cs+1));
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws IOException{
        ArrayList<Virus> viruses = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //n, k 입력 받기
         n = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());

         //시험관
         examiner = new int[n+1][n+1];

         //시험관 정보 입력 받기
         for(int i = 1; i <= n; i++){
             st = new StringTokenizer(br.readLine());
             for(int j = 1; j <= n; j++){
                 int t = Integer.parseInt(st.nextToken());
                 examiner[i][j] = t;
                 if(t != 0){
                     viruses.add(new Virus(i,j,t,0));
                 }
             }
         }

         //처음 전염시킬 바이러스들 정렬하여 virus(큐)에 넣기
         Collections.sort(viruses);
         for(int i = 0; i < viruses.size(); i++){
             virus.offer(viruses.get(i));
         }

         //초, x, y 입력 받기
         st =  new StringTokenizer(br.readLine());
         s = Integer.parseInt(st.nextToken());
         x = Integer.parseInt(st.nextToken());
         y = Integer.parseInt(st.nextToken());

         //전염
        inspection();

        System.out.print(examiner[x][y]);
    }
}
