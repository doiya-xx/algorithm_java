// 标题：二叉树的锯齿形层序遍历
// 标记：binary-tree-zigzag-level-order-traversal
// 编号：103
// 时间：2024-02-25 16:22:41

// 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [3,9,20,null,null,15,7]
// 输出：[[3],[20,9],[15,7]]
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
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 862 👎 0


package leetcode.editor.cn;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        
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
        
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isOrderLeft = true;
            while (!queue.isEmpty()) {
                Deque<Integer> levelList = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (isOrderLeft) {
                        levelList.offerLast(node.val);
                    } else {
                        levelList.offerFirst(node.val);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                list.add(new ArrayList<>(levelList));
                isOrderLeft = !isOrderLeft;
            }
            return list;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
    
}