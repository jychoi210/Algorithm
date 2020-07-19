package problem1;

import java.util.ArrayList;

public class prob8_zeroMatrix {

    public static void main(String args[]){
        int [][] matrix = {{1,2,3,0,1}, {2,3,4,1,2}, {0,1,1,1,1}, {2,3,0,1,1}};
        int [] col = new int[3];
        int [] row = new int[3];
        //ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    col[count] = i;
                    row[count] = j;
                    count++;
                }
            }
        }

        for(int i = 0; i < col.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[col[i]][j] = 0;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < row.length; j++) {
                matrix[i][row[j]] = 0;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }
}
