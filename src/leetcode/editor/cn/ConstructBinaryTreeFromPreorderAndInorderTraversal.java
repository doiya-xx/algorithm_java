// 标题：从前序与中序遍历序列构造二叉树
// 标记：construct-binary-tree-from-preorder-and-inorder-traversal
// 编号：105
// 时间：2024-02-25 16:28:10

// 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
// 返回其根节点。
//
// 
//
// 示例 1: 
// 
// 
// 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// 输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
// 输入: preorder = [-1], inorder = [-1]
// 输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2246 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        
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
        
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            int length = preorder.length;
            if (length == 1) {
                return new TreeNode(preorder[0]);
            }
            TreeNode root = new TreeNode(preorder[0]);
            int rootIndex = 0;
            for (int i = 0; i < length; i++) {
                if (inorder[i] == preorder[0]) {
                    rootIndex = i;
                    break;
                }
            }
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1), Arrays.copyOfRange(inorder, 0, rootIndex));
            root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, length), Arrays.copyOfRange(inorder, rootIndex + 1, length));
            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
    
}