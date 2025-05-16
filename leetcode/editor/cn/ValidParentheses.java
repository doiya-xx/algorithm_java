package leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3306 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }
            char[] chars = s.toCharArray();
            Map<Character, Character> dict = new HashMap<>();
            dict.put('(', ')');
            dict.put('[', ']');
            dict.put('{', '}');
            //使用StringBuild作为栈
            Stack<Character> stack = new Stack<>();
            for (char c : chars) {
                //遇到左括号添加进去
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    //判断栈是否为空
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        //遇到右括号，判断是否与构造器的最后一位相等
                        if (c != dict.get(stack.pop())) {
                            return false;
                        }
                    }
                }
            }
            //最后如果栈不为空，则返回false
            if (stack.isEmpty()){
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
    
}