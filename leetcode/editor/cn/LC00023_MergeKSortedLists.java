// 题目编号：23
// 题目标题：合并 K 个升序链表
// 题目标记：merge-k-sorted-lists

// 给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
// 输出：[1,1,2,3,4,4,5,6]
// 解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
// 将它们合并到一个有序链表中得到。
// 1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
// 输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
// 输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics链表 | 分治 | 堆（优先队列） | 归并排序 
//
// 👍 2825, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import cn.hutool.core.lang.Assert;
import commons.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC00023_MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new LC00023_MergeKSortedLists().new Solution();
        ListNode[] links1 = ListNode.links(new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}});
        ListNode res1 = solution.mergeKLists(links1);
        System.out.println("listNode = " + ListNode.toListString(res1));
        Assert.equals(ListNode.toListString(res1), "[1,1,2,3,4,4,5,6]");

        ListNode[] links2 = ListNode.links(new int[][]{});
        ListNode res2 = solution.mergeKLists(links2);
        System.out.println("listNode = " + ListNode.toListString(res2));
        Assert.equals(ListNode.toListString(res2), "[]");

        ListNode[] links3 = ListNode.links(new int[][]{{}});
        ListNode res3 = solution.mergeKLists(links3);
        System.out.println("listNode = " + ListNode.toListString(res3));
        Assert.equals(ListNode.toListString(res3), "[]");
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
        public ListNode mergeKLists(ListNode[] lists) {
            int length = lists.length;
            if (length == 0) {
                return null;
            }
            int count = 0;
            for (ListNode list : lists) {
                ListNode p = list;
                while (p != null) {
                    count++;
                    p = p.next;
                }
            }
            if (count == 0) {
                return null;
            }

            ListNode preHead = new ListNode();
            ListNode p = preHead;
            int index = -1;
            for (int k = 0; k < count; k++) {
                ListNode currentMin = new ListNode(Integer.MAX_VALUE);
                for (int i = 0; i < length; i++) {
                    if (lists[i] != null && lists[i].val < currentMin.val) {
                        currentMin = lists[i];
                        index = i;
                    }
                }
                p.next = currentMin;
                p = p.next;
                if (lists[index] != null) {
                    lists[index] = lists[index].next;
                }
            }
            return preHead.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists)
            if (head != null)
                pq.offer(head);

        ListNode dummy = new ListNode(); // 哨兵节点，作为合并后链表头节点的前一个节点
        ListNode cur = dummy;
        while (!pq.isEmpty()) { // 循环直到堆为空
            ListNode node = pq.poll(); // 剩余节点中的最小节点
            if (node.next != null) // 下一个节点不为空
                pq.offer(node.next); // 下一个节点有可能是最小节点，入堆
            cur.next = node; // 合并到新链表中
            cur = cur.next; // 准备合并下一个节点
        }
        return dummy.next; // 哨兵节点的下一个节点就是新链表的头节点
    }

}