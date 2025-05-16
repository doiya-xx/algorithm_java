// 标题：无重复字符的最长子串
// 标记：longest-substring-without-repeating-characters
// 编号：3
// 时间：2024-02-27 21:41:39

// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
// 输入: s = "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
// 输入: s = "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
// 输入: s = "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9996 👎 0


package leetcode.editor.cn;

public class LongestSubstringWithoutRepeatingCharacters {
    
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] last = new int[128]; // 创建一个数组，用于存储每个字符最后出现的位置
            int n = s.length(); // 获取输入字符串的长度
            int res = 0; // 初始化结果为0，用于存储最长子串的长度
            for (int i = 0, j = 0; j < n; j++) { // i和j分别表示滑动窗口的左右边界
                i = Math.max(i, last[s.charAt(j)]); // 更新左边界i为当前字符上次出现的位置和当前i的较大值
                res = Math.max(res, j - i + 1); // 更新结果res为当前最长子串长度和res的较大值
                last[s.charAt(j)] = j + 1; // 更新当前字符的最后出现位置
            }
            return res; // 返回最长子串的长度
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
    
}