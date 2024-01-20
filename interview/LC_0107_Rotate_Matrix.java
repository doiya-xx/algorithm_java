package interview;

/*
LeetCode 48
 */
class solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        printMatrix(matrix);
        System.out.println();
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
                printMatrix(matrix);
                System.out.println();
            }
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}



public class LC_0107_Rotate_Matrix {
    public static void main(String[] args) {
        solution solu = new solution();
        // 测试三维数组
        // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        // solu.rotate(matrix);
        // 测试四维数组
        int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        solu.rotate(matrix2);
    }
}
