/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * <p>
 * Related Topics 数组 矩阵 模拟 👍 1926 👎 0
 */

package leetcode.editor.cn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class LC0054_SpiralMatrix {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix.length == 0) return new ArrayList<>();
            int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
            Integer[] res = new Integer[(r + 1) * (b + 1)];
            while (true) {
                for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right
                if (++t > b) break;
                for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom
                if (l > --r) break;
                for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left
                if (t > --b) break;
                for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top
                if (++l > r) break;
            }
            return Arrays.asList(res);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}