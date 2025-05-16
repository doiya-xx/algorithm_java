// 题目编号：76
// 题目标题：最小覆盖子串
// 题目标记：minimum-window-substring

// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "ADOBECODEBANC", t = "ABC"
// 输出："BANC"
// 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
// 输入：s = "a", t = "a"
// 输出："a"
// 解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
// 输入: s = "a", t = "aa"
// 输出: ""
// 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
// 因此没有符合条件的子字符串，返回空字符串。
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
// 进阶：你能设计一个在
// o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 2918, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LC00076_MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new LC00076_MinimumWindowSubstring().new Solution();
        String s1 = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println("s1 = " + s1);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, Integer> ori = new HashMap<>();
        Map<Character, Integer> cnt = new HashMap<>();

        public String minWindow(String s, String t) {
            for (char c : t.toCharArray()) {
                ori.compute(c, (k, v) -> v == null ? 1 : v + 1);
            }
            int l = 0, r = 0;
            int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
            int sLen = s.length();
            while (r < sLen) {
                char sr = s.charAt(r);
                cnt.compute(sr, (k, v) -> v == null ? 1 : v + 1);
                while (check() && l <= r) {
                    if (r - l + 1 < len) {
                        len = r - l + 1;
                        ansL = l;
                        ansR = l + len;
                    }
                    char sl = s.charAt(l);
                    cnt.compute(sl, (k, v) -> v == null ? -1 : v - 1);
                    ++l;
                }
                ++r;
            }
            return ansL == -1 ? "" : s.substring(ansL, ansR);
        }

        public boolean check() {
            for (Character c : ori.keySet()) {
                if (cnt.getOrDefault(c, 0)<ori.get(c)) {
                    return false;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}