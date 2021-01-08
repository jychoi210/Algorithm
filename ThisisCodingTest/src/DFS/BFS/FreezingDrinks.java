package DFS.BFS;

// 이것이 코딩 테스트다.
// Chapter 5 : DFS,BFS 문제 1 음료수 얼려 먹기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FreezingDrinks {
    public static int n, m;
    public static int map[][] = new int[1000][1000];

    public static void dfs(int x, int y){
        //map을 벗어난다면 종료
        if(x <= -1 || x >= n || y <= -1 || y >= m) return;

        //방문하지 않았다면 방문 표시를 한 후, 상하좌우에 대해 dfs 호출
        if(map[x][y] == 0) {
            map[x][y] = 1;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
        }
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //위에 1000x1000이 아닌 n,m으로 선언할 시 필요
        //map = new int[n][m];

        //map 정보 입력 받기
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for(int j = 0; j < m; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        int result = 0;

        //dfs 실행하면 결과값 + 1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    dfs(i,j);
                    result++;
                }
            }
        }

        System.out.println(result);

    }

}
