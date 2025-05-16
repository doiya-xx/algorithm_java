// 题目编号：20
// 题目标题：有效的括号
// 题目标记：valid-parentheses

// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "()"
// 输出：true
// 
//
// 示例 2： 
//
// 
// 输入：s = "()[]{}"
// 输出：true
// 
//
// 示例 3： 
//
// 
// 输入：s = "(]"
// 输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics栈 | 字符串 
//
// 👍 4455, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LC00020_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LC00020_ValidParentheses().new Solution();
        boolean valid = solution.isValid("(((((((()))))))))))))");
        System.out.println("valid = " + valid);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {

            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }

            Map<Character, Character> map = new HashMap<Character, Character>() {{
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }};

            Deque<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    if (stack.isEmpty() || stack.peek() != map.get(c)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}