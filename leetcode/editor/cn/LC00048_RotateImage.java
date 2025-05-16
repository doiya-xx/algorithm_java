// 题目编号：48
// 题目标题：旋转图像
// 题目标记：rotate-image

//<p>给定一个 <em>n&nbsp;</em>×&nbsp;<em>n</em> 的二维矩阵&nbsp;<code>matrix</code> 表示一个图像。请你将图像顺时针旋转 90 度。</p>
//
//<p>你必须在<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地</a></strong> 旋转图像，这意味着你需要直接修改输入的二维矩阵。<strong>请不要 </strong>使用另一个矩阵来旋转图像。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg" style="height: 188px; width: 500px;" /> 
//<pre>
//<strong>输入：</strong>matrix = [[1,2,3],[4,5,6],[7,8,9]]
//<strong>输出：</strong>[[7,4,1],[8,5,2],[9,6,3]]
//</pre>
//
//<p><strong>示例 2：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg" style="height: 201px; width: 500px;" /> 
//<pre>
//<strong>输入：</strong>matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//<strong>输出：</strong>[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>n == matrix.length == matrix[i].length</code></li> 
// <li><code>1 &lt;= n &lt;= 20</code></li> 
// <li><code>-1000 &lt;= matrix[i][j] &lt;= 1000</code></li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 矩阵</details><br>
//
//<div>👍 1872, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
//
//
//
//

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LC00048_RotateImage {
    public static void main(String[] args) {
        Solution solution = new LC00048_RotateImage().new Solution();
        int n = 4;
        int rows = n;
        int cols = n;
        int[][] matrix = IntStream
                .range(0, rows)
                .mapToObj(i -> {
                    int first = i * rows + 1;
                    return IntStream.range(first, first + cols).toArray();
                })
                .toArray(int[][]::new);
        System.out.println("matrix = " + Arrays.deepToString(matrix));
        solution.rotate(matrix);
        System.out.println("matrix = " + Arrays.deepToString(matrix));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int n;

        private void swap(int q, int p) {
            int temp = q;
            q = p;
            p = temp;
        }

        // 上下对称
        private void upDownSymmetry(int[][] matrix) {
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n; j++) {
                    // swap(matrix[i][j], matrix[n-i-1][j]);
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[n - i - 1][j];
                    matrix[n - i - 1][j] = t;
                }
            }
        }

        // 左右对称
        private void leftRightSymmetry(int[][] matrix) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    // swap(matrix[i][j], matrix[i][n-j-1]);
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = t;
                }
            }
        }

        // 主对角线对称
        private void mainDiagSymmetry(int[][] matrix) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    // swap(matrix[i][j], matrix[j][i]);
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }

        // 副对角线对称
        private void subDiagSymmetry(int[][] matrix) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    swap(matrix[i][j], matrix[n - j - 1][n - i - 1]);
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][n - i - 1];
                    matrix[n - j - 1][n - i - 1] = t;
                }
            }
        }

        public void rotate(int[][] matrix) {
            n = matrix.length;

            // 顺时针旋转90°
            upDownSymmetry(matrix);
            mainDiagSymmetry(matrix);

            // 逆时针旋转90°
            // leftRightSymmetry(matrix);
            // mainDiagSymmetry(matrix);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}