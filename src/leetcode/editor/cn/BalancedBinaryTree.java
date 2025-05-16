// 标题：平衡二叉树
// 标记：balanced-binary-tree
// 编号：110
// 时间：2024-02-27 23:15:12

// 给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [3,9,20,null,null,15,7]
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：root = [1,2,2,3,3,null,null,4,4]
// 输出：false
// 
//
// 示例 3： 
//
// 
// 输入：root = []
// 输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1486 👎 0


package leetcode.editor.cn;

public class BalancedBinaryTree {
    
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        
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
        
        public int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
        
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isBalanced(root.left) || !isBalanced(root.right)) {
                return false;
            }
            return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
    
}