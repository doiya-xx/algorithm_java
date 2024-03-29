// 标题：不同的二叉搜索树
// 标记：unique-binary-search-trees
// 编号：96
// 时间：2024-02-25 14:44:34

//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
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
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2452 👎 0


package leetcode.editor.cn;

public class UniqueBinarySearchTrees {
    
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        // 如果节点数量为0或1，那么只能构成一种BST，所以返回1
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // 初始化动态规划数组，长度为节点数量n+1
        int[] dp = new int[n + 1];
        
        // 当节点数量为0时，只有一种BST
        dp[0] = 1;
        
        // 对于每一个数量i（从1到n）
        for (int i = 1; i <= n; i++) {
            // 对于每一个数量j（从0到i）
            for (int j = 0; j < i; j++) {
                // dp[i]等于dp[j]和dp[i-j-1]的乘积的和
                // dp[j]表示左子树的可能BST数量
                // dp[i-j-1]表示右子树的可能BST数量
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        
        // 返回节点数量为n时的可能BST数量
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}