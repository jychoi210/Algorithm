import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class NTS_pretest {
    static int[][] matrix;
    static Queue<Integer> q = new LinkedList<>();
    static List<Integer> sizeArr = new ArrayList<>();
    static int N;
    static int count;

    public static void main(String args[]) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];
        boolean check = true;
        count = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(reader.readLine()," ");
            for(int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j]==1) check = false;
            }
        }

        if(check){
            System.out.println(0);
        }else{
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(matrix[i][j]==1){
                        count = 1;
                        matrix[i][j] = 0;
                        BFS(i,j);
                        sizeArr.add(count);
                    }
                }
            }
        }
        sizeArr.sort(null);
        System.out.println(sizeArr.size());
        for(int i = 0; i < sizeArr.size(); i++){
            System.out.print(sizeArr.get(i) + " ");
        }

    }

    public static void BFS(int x, int y){

        if(x > 0 && matrix[x-1][y] == 1){
            matrix[x-1][y] = 0;
            q.add(x-1);
            q.add(y);
        }
        if(x < N-1 && matrix[x+1][y] == 1){
            matrix[x+1][y] = 0;
            q.add(x+1);
            q.add(y);
        }
        if(y > 0 && matrix[x][y-1] == 1){
            matrix[x][y-1] = 0;
            q.add(x);
            q.add(y-1);
        }
        if(y < N-1 && matrix[x][y+1] == 1){
            matrix[x][y+1] = 0;
            q.add(x);
            q.add(y+1);
        }
        if(!q.isEmpty()){
            count++;
            BFS(q.poll(),q.poll());
        }
    }
}
