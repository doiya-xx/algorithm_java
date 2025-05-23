// 题目编号：21
// 题目标题：合并两个有序链表
// 题目标记：merge-two-sorted-lists

// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
// 
// 
// 输入：l1 = [1,2,4], l2 = [1,3,4]
// 输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
// 输入：l1 = [], l2 = []
// 输出：[]
// 
//
// 示例 3： 
//
// 
// 输入：l1 = [], l2 = [0]
// 输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics递归 | 链表 
//
// 👍 3521, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import commons.ListNode;

public class LC00021_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new LC00021_MergeTwoSortedLists().new Solution();
        ListNode l1 = ListNode.link(new int[]{1, 2, 4});
        System.out.println("l1 = " + l1);
        ListNode l2 = ListNode.link(new int[]{1, 3, 4});
        System.out.println("l2 = " + l2);
        ListNode res1 = solution.mergeTwoLists(l1, l2);
        System.out.println("res1 = " + res1);
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
            prev.next = l1 == null ? l2 : l1;

            return prehead.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}