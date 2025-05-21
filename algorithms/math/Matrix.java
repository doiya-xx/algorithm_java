package algorithms.math;

public class Matrix {

    /**
     * 水平翻转矩阵（上下翻转）
     * @param matrix
     */
    public static void horizontalFlipMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
    }

    /**
     * 左右翻转矩阵
     */
    public static void verticalFlipMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    /**
     * 主对角线翻转
     */
    public static void mainDiagonalFlipMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * 副对角线翻转
     */
    public static void secondaryDiagonalFlipMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
    }

    /**
     * 顺时针旋转矩阵，通过原地旋转实现
     */
    public static void rotateMatrixClockwise1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    /**
     * 顺时针旋转矩阵，通过水平翻转和主对角线翻转实现
     */
    public static void rotateMatrixClockwise2(int[][] matrix) {
        horizontalFlipMatrix(matrix);
        mainDiagonalFlipMatrix(matrix);
    }

    /**
     * 逆时针旋转矩阵，通过水平翻转和副对角线翻转实现
     */
    public static void rotateMatrixCounterClockwise(int[][] matrix) {
        horizontalFlipMatrix(matrix);
        secondaryDiagonalFlipMatrix(matrix);
    }


}
