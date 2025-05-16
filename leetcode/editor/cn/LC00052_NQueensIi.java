// 题目编号：52
// 题目标题：N 皇后 II
// 题目标记：n-queens-ii

// n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
// 输入：n = 4
// 输出：2
// 解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 
// 
//
// 示例 2： 
//
// 
// 输入：n = 1
// 输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics回溯 
//
// 👍 517, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC00052_NQueensIi {
    public static void main(String[] args) {
        Solution solution = new LC00052_NQueensIi().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int n) {
            return solve(n, 0, 0, 0, 0);
        }

        public int solve(int n, int row, int columns, int diagonals1, int diagonals2) {
            if (row == n) {
                return 1;
            } else {
                int count = 0;
                int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
                while (availablePositions != 0) {
                    int position = availablePositions & (-availablePositions);
                    availablePositions = availablePositions & (availablePositions - 1);
                    count += solve(n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                }
                return count;
            }
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}