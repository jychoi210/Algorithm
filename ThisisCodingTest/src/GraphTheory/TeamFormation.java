package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 10 : 그래프 이론 문제 1 팀 결성

import java.util.ArrayList;
import java.util.Scanner;

public class TeamFormation { 
    //n개의 팀과 m개의 연산
    public static int n, m;
    //team 테이블 초기화
    public static int[] team = new int[100001];

    //팀 찾기
    public static int findTeam(int x){
        if(team[x] == x) return x;
        return team[x] = findTeam(team[x]);
    }

    //팀 합치기
    public static void unionTeam(int a, int b){
        a = findTeam(a);
        b = findTeam(b);
        //작은 수를 가진 학생을 기준으로
        if(a>b) team[a] = b;
        else team[b] = a;
    }

    public static void main(String args[]){
        //결과 값을 저장할 result 리스트
        ArrayList<String> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //n, m 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();

        //팀 초기화. 자기 자신의 팀으로
        for(int i = 0; i < n + 1; i++){
            team[i] = i;
        }

        //연산과 a, b를 입력받아 연산이 0이면 팀을 합치고 1이면 같은 팀 여부를 확인
        for(int i = 0; i < m; i++){
            int z = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if( z == 0 ){
                unionTeam(a, b);
            }
            else{
                //이렇게 하면 바로 출력됨
                //System.out.println(findTeam(a)==findTeam(b) ? "YES" : "NO");
                if(findTeam(a)== findTeam(b)) result.add("YES");
                else result.add("NO");
            }
        }

        for(String s : result){
            System.out.println(s);
        }
    }
}
