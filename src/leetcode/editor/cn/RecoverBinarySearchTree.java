// 标题：恢复二叉搜索树
// 标记：recover-binary-search-tree
// 编号：99
// 时间：2024-02-25 15:25:11

//给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？ 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 939 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RecoverBinarySearchTree {
    
    public static void main(String[] args) {
        Solution solution = new RecoverBinarySearchTree().new Solution();
        
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
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private List<TreeNode> getInorderTraversalByStack(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node);
                node = node.right;
            }
        }
        return list;
    }
    public void recoverTree(TreeNode root) {
        // 获取中序遍历的结果
        List<TreeNode> inorder = getInorderTraversalByStack(root);
        // 使用stream，获取List中需要交换的两个节点
        TreeNode x = null, y = null;
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i).val > inorder.get(i + 1).val) {
                y = inorder.get(i + 1);
                if (x == null) {
                    x = inorder.get(i);
                } else {
                    break;
                }
            }
        }
        // 交换两个节点的值
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}