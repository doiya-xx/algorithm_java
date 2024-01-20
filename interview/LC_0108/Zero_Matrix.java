package interview.LC_0108;

import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[] rows = new boolean[n], cols = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) rows[i] = cols[j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] || cols[j]) matrix[i][j] = 0;
            }
        }
    }
}

public class Zero_Matrix {
    public static void main(String[] args) {
        // 测试
        Solution solution = new Solution();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
