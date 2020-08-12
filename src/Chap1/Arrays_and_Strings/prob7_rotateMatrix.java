package Chap1.Arrays_and_Strings;

public class prob7_rotateMatrix {
    public static void main(String args[]){
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        if(rotateMatrix(matrix)){
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix.length; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println("");
            }
        }

    }

    public static boolean rotateMatrix(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length != matrix.length) return false;
        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++){
                int num = i - first;
                int temp = matrix[layer][i];

                matrix[layer][i] = matrix[last-num][layer];

                matrix[last - num][layer] = matrix[last][last - num];

                matrix[last][last - num] = matrix[i][last];

                matrix[i][last]  = temp;
            }
        }
        return true;
    }
}
