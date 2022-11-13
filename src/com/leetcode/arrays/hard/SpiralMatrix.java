package com.leetcode.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int VISITED = 101;// not in range;
        List<Integer> res = new ArrayList<>();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = matrix.length;
        int cols = matrix[0].length;
        int way = 0;
        int r = 0, c = 0;
        int changeDir = 0;
        res.add(matrix[0][0]);
        matrix[0][0] = VISITED;
        while (changeDir < 2) {
            while (r + dir[way][0] >= 0 && r + dir[way][0] < row && c + dir[way][1] >= 0 && c + dir[way][1] < cols
                    && matrix[r + dir[way][0]][c + dir[way][1]] != VISITED) {
                changeDir = 0;
                //no direction change;

                r = r + dir[way][0];
                c = c + dir[way][1];
                res.add(matrix[r][c]);
                matrix[r][c] = VISITED;
            }
            way = (way + 1) % 4;
            changeDir++;
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
