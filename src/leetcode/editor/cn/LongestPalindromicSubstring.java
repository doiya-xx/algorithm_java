// 标题：最长回文子串
// 标记：longest-palindromic-substring
// 编号：5
// 时间：2024-02-27 21:46:31

// 给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "babad"
// 输出："bab"
// 解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
// 输入：s = "cbbd"
// 输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 7079 👎 0


package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) return "";
            int length = s.length();
            int start = 0, end = 0;
            for (int i = 0; i < length; i++) {
                if (length - i <= (end - start) / 2) {
                    break;
                }
                int left = i, right = i;
                while (right < length - 1 && s.charAt(right) == s.charAt(right + 1)) {
                    right++; // Skip duplicate characters.
                }
                while (left > 0 && right < length - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                    left--;
                    right++;
                }
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
            }
            return s.substring(start, end + 1);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
    
}