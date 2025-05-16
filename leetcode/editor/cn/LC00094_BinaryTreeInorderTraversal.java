// 题目编号：94
// 题目标题：二叉树的中序遍历
// 题目标记：binary-tree-inorder-traversal

// 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [1,null,2,3]
// 输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
// 输入：root = []
// 输出：[]
// 
//
// 示例 3： 
//
// 
// 输入：root = [1]
// 输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 2075, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC00094_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new LC00094_BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        public void inorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }

        public List<Integer> inorderByStack(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stk = new LinkedList<>();
            while (root != null || !stk.isEmpty()) {
                while (root != null) {
                    stk.push(root);
                    root = root.left;
                }
                root = stk.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }

        public List<Integer> inorderByMorris(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            TreeNode predecessor = null;
            while (root != null) {
                if (root.left != null) {
                    // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                    predecessor = root.left;
                    while (predecessor.right != null && predecessor.right != root) {
                        predecessor = predecessor.right;
                    }
                    // 让 predecessor 的右指针指向 root，继续遍历左子树
                    if (predecessor.right == null) {
                        predecessor.right = root;
                        root = root.left;
                    }
                    // 说明左子树已经访问完了，我们需要断开链接
                    else {
                        res.add(root.val);
                        predecessor.right = null;
                        root = root.right;
                    }
                }
                // 如果没有左孩子，则直接访问右孩子
                else {
                    res.add(root.val);
                    root = root.right;
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}