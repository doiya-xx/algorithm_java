// 题目编号：98
// 题目标题：验证二叉搜索树
// 题目标记：validate-binary-search-tree

// 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [2,1,3]
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：root = [5,1,4,null,null,3,6]
// 输出：false
// 解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉搜索树 | 二叉树 
//
// 👍 2330, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import commons.TreeNode;

public class LC00098_ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new LC00098_ValidateBinarySearchTree().new Solution();
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
        /*
         * 时间复杂度：O(n)
         * 空间复杂的：O(n)
         */
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode root, int min, int max) {
            if (root == null) {
                return true;
            }
            if (root.val <= min || root.val >= max) {
                return false;
            }
            boolean leftIsValidBST = isValidBST(root.left, min, root.val);
            boolean rightIsValidBST = isValidBST(root.right, root.val, max);
            return leftIsValidBST && rightIsValidBST;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}