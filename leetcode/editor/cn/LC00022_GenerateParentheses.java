// 题目编号：22
// 题目标题：括号生成
// 题目标记：generate-parentheses

// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 3
// 输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
// 输入：n = 1
// 输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 3592, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LC00022_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new LC00022_GenerateParentheses().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        ArrayList[] cache = new ArrayList[100];

        public List<String> generate(int n) {
            if (cache[n] != null) {
                return cache[n];
            }
            ArrayList<String> ans = new ArrayList<>();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; ++c) {
                    for (String left : generate(c)) {
                        for (String right : generate(n - 1 - c)) {
                            ans.add("(" + left + ")" + right);
                        }
                    }
                }
            }
            cache[n] = ans;
            return ans;
        }

        public List<String> generateParenthesis(int n) {
            return generate(n);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}