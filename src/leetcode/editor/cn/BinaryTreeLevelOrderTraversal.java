// 标题：二叉树的层序遍历
// 标记：binary-tree-level-order-traversal
// 编号：102
// 时间：2024-02-25 16:18:27

// 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [3,9,20,null,null,15,7]
// 输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
// 输入：root = [1]
// 输出：[[1]]
// 
//
// 示例 3： 
//
// 
// 输入：root = []
// 输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1902 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        
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
        
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            // 创建一个队列
            Queue<TreeNode> queue = new LinkedList<>();
            // 将根节点入队
            queue.offer(root);
            List<List<Integer>> list = new ArrayList<>(); // 用于存放遍历结果
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> subList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    // 出队
                    TreeNode node = queue.poll();
                    subList.add(node.val);
                    // 如果左子节点不为空，则入队
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    // 如果右子节点不为空，则入队
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                list.add(subList);
            }
            return list;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
    
}