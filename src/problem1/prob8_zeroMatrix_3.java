package problem1;

import java.util.ArrayList;

public class prob8_zeroMatrix_3 {
    public static void main(String args[]) {
        int[][] matrix = {{1, 2, 3, 0, 1}, {2, 3, 4, 1, 2}, {0, 1, 1, 1, 1}, {2, 3, 0, 1, 1}};

        matrix = zeroMatrix(matrix);
        for(int[] item : matrix){
            for(int item2 : item) {
                System.out.print(item2);
            }
            System.out.println("");
        }
    }

    public static int[][] zeroMatrix(int[][] matrix){
        boolean col = false;
        boolean row = false;

        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                row = true;
            }
        }

        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                col = true;
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                for(int j = 0; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(row){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        if(col){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

        return matrix;
    }
}
