// 题目编号：96
// 题目标题：不同的二叉搜索树
// 题目标记：unique-binary-search-trees

// 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
// 
//
// 示例 1： 
// 
// 
// 输入：n = 3
// 输出：5
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
// 1 <= n <= 19 
// 
//
// Related Topics树 | 二叉搜索树 | 数学 | 动态规划 | 二叉树 
//
// 👍 2502, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC00096_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new LC00096_UniqueBinarySearchTrees().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            int[] G = new int[n + 1];
            G[0] = 1;
            G[1] = 1;

            for (int i = 2; i <= n; ++i) {
                for (int j = 1; j <= i; ++j) {
                    G[i] += G[j - 1] * G[i - j];
                }
            }
            return G[n];
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
    class Solution2 {

        // 卡塔兰数
        public int numTrees(int n) {
            // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
            long C = 1;
            for (int i = 0; i < n; ++i) {
                C = C * 2 * (2L * i + 1) / (i + 2);
            }
            return (int) C;
        }
    }

}