package ShortestPath;

// 이것이 코딩 테스트다.
// Chapter 17 : 최단 경로 기출 2 정확한 순위 해답
// K 대회

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AccurateRanking_sol {
    public static final int INF = (int)1e9;
    public static int n, m;
    public static int[][] student = new int[501][501];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //학생 수 입력 받기
        n = Integer.parseInt(st.nextToken());
        //성적 비교한 결과 수 입력 받기
        m = Integer.parseInt(st.nextToken());

        //student[][] INF로 초기화 하기
        Arrays.stream(student).forEach((int[] line) -> Arrays.fill(line, INF));

        //학생 자기 자신과의 비교는 0으로 초기화
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i==j) student[i][j] = 0;
            }
        }

        //성적 비교한 결과 담기
        //a학생의 성적이 b학생의 성적보다 낮다는 것을 의미
        //즉, 한 행에 자신보다 점수가 낮은 학생들을 표시
        for(int i  = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            student[a][b] = 1;
        }

        //플로이드 워셜 알고리즘 사용
        //a->b 비용과 a->k->b 비용 비교하여 최소 비용 구하기
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <=n; b++){
                    student[a][b] = Math.min(student[a][b] , student[a][k] + student[k][b]);
                }
            }
        }

        //student[a][b] 와 studnet[b][a] 모두 INF라면 성적 비교 불가
        //따라서 둘 중 하나만 INF가 아니더라도 count하여 총 n개가 나오면 정확한 순위를 알 수 있음
        int result = 0;
        for(int i  = 1; i <= n; i++){
            int count = 0;
            for(int j = 1; j <=n; j++){
                if(student[i][j] != INF || student[j][i] != INF) count++;
            }
            if(count == n) result++;
        }

        System.out.print(result);
    }
}
