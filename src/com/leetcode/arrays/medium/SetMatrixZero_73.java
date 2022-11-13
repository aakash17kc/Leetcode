package com.leetcode.arrays.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SetMatrixZero_73 {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Boolean isCol = false;

        for (int i = 0; i < R; i++) {

            if(matrix[i][0]==0)
                isCol = true;

            for (int j = 1; j < C; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }

        //mark row
        if(matrix[0][0]==0){
            for(int i=0;i<C;i++){
                matrix[0][i]=0;
            }
        }

        //mark col
        if(isCol){
            for (int i = 0; i < R; i++) {
                matrix[i][0]=0;
            }
        }
    }
    public static void main(String[] args) {
        int matrix[][] = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new SetMatrixZero_73().setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
