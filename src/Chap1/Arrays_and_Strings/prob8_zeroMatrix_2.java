package Chap1.Arrays_and_Strings;

import java.util.ArrayList;

public class prob8_zeroMatrix_2 {

    public static void main(String args[]){
        int [][] matrix = {{1,2,3,0,1}, {2,3,4,1,2}, {0,1,1,1,1}, {2,3,0,1,1}};
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    list.add(new Integer[] {i,j});
                }
            }
        }

        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < matrix.length; j++) {
                matrix[j][list.get(i)[1]] = 0;
            }
        }

        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[list.get(i)[0]][j] = 0;
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
