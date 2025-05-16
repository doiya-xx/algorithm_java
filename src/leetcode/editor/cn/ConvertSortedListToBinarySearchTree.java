// 标题：有序链表转换二叉搜索树
// 标记：convert-sorted-list-to-binary-search-tree
// 编号：109
// 时间：2024-02-27 23:00:15

// 给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。 
//
// 
//
// 示例 1: 
//
// 
//
// 
// 输入: head = [-10,-3,0,5,9]
// 输出: [0,-3,9,-10,null,5]
// 解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
// 
//
// 示例 2: 
//
// 
// 输入: head = []
// 输出: []
// 
//
// 
//
// 提示: 
//
// 
// head 中的节点数在[0, 2 * 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 889 👎 0


package leetcode.editor.cn;

public class ConvertSortedListToBinarySearchTree {
    
    public static void main(String[] args) {
        Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
        
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
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
        class ListNode {
            public int val;
            public ListNode next;
            ListNode(int x) {
                val = x;
            }
            ListNode(int x, ListNode next) {
                val = x;
                this.next = next;
            }
        }
        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {
            }
            TreeNode( int val){
                this.val = val;
            }
            TreeNode( int val, TreeNode left, TreeNode right){
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
        
        public TreeNode sortedListToBST(ListNode head) {
            // 如果链表为空，返回null
            if (head == null) {
                return null;
            }
            
            // 如果链表只有一个节点，返回这个节点作为树的根节点
            if (head.next == null) {
                return new TreeNode(head.val);
            }
            
            // 使用快慢指针找到链表的中间节点
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            
            // 断开链表在中间节点处，将链表分为两部分
            prev.next = null;
            
            // 创建根节点
            TreeNode root = new TreeNode(slow.val);
            
            // 递归地将链表的左半部分和右半部分转换为左子树和右子树
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(slow.next);
            
            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
    
}