// 标题：不同的二叉搜索树 II
// 标记：unique-binary-search-trees-ii
// 编号：95
// 时间：2024-02-25 14:53:13

// 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
//
// 
//
// 
// 
// 示例 1： 
// 
// 
// 输入：n = 3
// 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
// 
// 
//
// 示例 2： 
//
// 
// 输入：n = 1
// 输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1531 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesIi {
    
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
        
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            
            TreeNode() {
            }
            
            TreeNode(int val) {
                this.val = val;
            }
            
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
        
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            return generateTrees(1, n);
        }
        
        private List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> allTrees = new ArrayList<>();
            if (start > end) {
                allTrees.add(null);
                return allTrees;
            }
            
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = generateTrees(start, i - 1);
                List<TreeNode> rightTrees = generateTrees(i + 1, end);
                
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode cur = new TreeNode(i);
                        cur.left = left;
                        cur.right = right;
                        allTrees.add(cur);
                    }
                }
            }
            return allTrees;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
    
}