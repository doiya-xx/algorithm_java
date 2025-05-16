// 题目编号：104
// 题目标题：二叉树的最大深度
// 题目标记：maximum-depth-of-binary-tree

//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1838, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import algorithms.tree.BinaryTree;
import commons.TreeNode;

public class LC00104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new LC00104_MaximumDepthOfBinaryTree().new Solution();
        Integer[] integers1 = {3,9,20,null,null,15,7};
        TreeNode root1 = BinaryTree.constructTreeFromLevelOrder(integers1);
        int res1 = solution.maxDepth(root1);
        System.out.println("res1 = " + res1);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}