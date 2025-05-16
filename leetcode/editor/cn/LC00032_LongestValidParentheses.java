// 题目编号：32
// 题目标题：最长有效括号
// 题目标记：longest-valid-parentheses

// 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
// 输入：s = "(()"
// 输出：2
// 解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
// 输入：s = ")()())"
// 输出：4
// 解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
// 输入：s = ""
// 输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics栈 | 字符串 | 动态规划 
//
// 👍 2514, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class LC00032_LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LC00032_LongestValidParentheses().new Solution();
        int res1 = solution.longestValidParentheses(")()())");
        System.out.println("res1 = " + res1);

        int res2 = solution.longestValidParentheses(")()()())()())()()()()())()()))())()))(()()()(())");
        System.out.println("res1 = " + res2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}