package leetcode.editor.cn;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
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
// Related Topics 递归 链表 👍 2468 👎 0

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
    
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
        public class ListNode {
            int val;
            ListNode next;
            
            ListNode() {
            }
            
            ListNode(int val) {
                this.val = val;
            }
            
            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
        
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            ListNode insert, inserted, result;
            if (list1.val < list2.val) {
                insert = list2;
                inserted = list1;
            } else {
                insert = list1;
                inserted = list2;
            }
            result = inserted;
            while (insert != null) {
                // 判断是否有下一个可以进行比较
                if (inserted.next != null) {
                    // 判断是否能插入；执行插入
                    if (insert.val <= inserted.next.val) {
                        inserted.next = new ListNode(insert.val, inserted.next);
                        // 移动被插入的链表指针
                        insert = insert.next;
                    }
                    inserted = inserted.next;
                } else {
                    inserted.next = new ListNode(insert.val,null);
                    insert = insert.next;
                    inserted = inserted.next;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
    
}