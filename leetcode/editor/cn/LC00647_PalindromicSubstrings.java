// 题目编号：647
// 题目标题：回文子串
// 题目标记：palindromic-substrings

// 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "abc"
// 输出：3
// 解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
// 输入：s = "aaa"
// 输出：6
// 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics双指针 | 字符串 | 动态规划 
//
// 👍 1335, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC00647_PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new LC00647_PalindromicSubstrings().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int n = s.length(), ans = 0;
            for (int i = 0; i < 2 * n - 1; ++i) {
                int l = i / 2, r = i / 2 + i % 2;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    --l;
                    ++r;
                    ++ans;
                }
            }
            return ans;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
    class Solution2 {
        public int countSubstrings(String s) {
            int n = s.length();
            StringBuilder t = new StringBuilder("$#");
            for (int i = 0; i < n; ++i) {
                t.append(s.charAt(i));
                t.append('#');
            }
            n = t.length();
            t.append('!');

            int[] f = new int[n];
            int iMax = 0, rMax = 0, ans = 0;
            for (int i = 1; i < n; ++i) {
                // 初始化 f[i]
                f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
                // 中心拓展
                while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                    ++f[i];
                }
                // 动态维护 iMax 和 rMax
                if (i + f[i] - 1 > rMax) {
                    iMax = i;
                    rMax = i + f[i] - 1;
                }
                // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
                ans += f[i] / 2;
            }

            return ans;
        }
    }

}