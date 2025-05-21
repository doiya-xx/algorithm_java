/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 * <p>
 * <p>
 * <p>
 * <p>
 * Related Topics 数组 数学 矩阵 👍 2057 👎 0
 */

package leetcode.editor.cn;

public class LC0048_RotateImage {

    public static void main(String[] args) {
        Solution solution = new LC0048_RotateImage().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 原地旋转，即交换对应位置
         *
         * @param matrix
         */
        public void rotate(int[][] matrix) {
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
    }
    // leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {

        /*
        使用辅助矩阵
         */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 深拷贝 matrix -> tmp
            int[][] tmp = new int[n][];
            for (int i = 0; i < n; i++)
                tmp[i] = matrix[i].clone();
            // 根据元素旋转公式，遍历修改原矩阵 matrix 的各元素
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[j][n - 1 - i] = tmp[i][j];
                }
            }
        }
    }

    class Solution3 {

        /**
         * 翻转矩阵
         *
         * @param matrix
         */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 水平翻转
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < n; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - i - 1][j];
                    matrix[n - i - 1][j] = temp;
                }
            }
            // 主对角线翻转
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

}