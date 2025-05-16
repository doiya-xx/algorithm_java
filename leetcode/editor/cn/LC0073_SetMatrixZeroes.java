/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2³¹ <= matrix[i][j] <= 2³¹ - 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * <p>
 * <p>
 * Related Topics 数组 哈希表 矩阵 👍 1206 👎 0
 */

package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC0073_SetMatrixZeroes {

    @Test
    public void testSolution() {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] target = {{0,0,0,0},{0,4,5,0},{0,3,1,0}};
        Solution solution = new Solution();
        solution.setZeroes(matrix);
        Assertions.assertArrayEquals(matrix, target);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(target));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
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
    // leetcode submit region end(Prohibit modification and deletion)


}