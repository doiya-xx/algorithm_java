// 题目编号：14
// 题目标题：最长公共前缀
// 题目标记：longest-common-prefix

// 编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
// 输入：strs = ["flower","flow","flight"]
// 输出："fl"
// 
//
// 示例 2： 
//
// 
// 输入：strs = ["dog","racecar","car"]
// 输出：""
// 解释：输入不存在公共前缀。
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics字典树 | 字符串 
//
// 👍 3130, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC00014_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LC00014_LongestCommonPrefix().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            for (String string : strs) {
                if (string.length() < prefix.length()) {
                    prefix = string;
                }
            }
            for (String string : strs) {
                while (!string.startsWith(prefix)) {
                    if (prefix.length() == 1) {
                        return "";
                    }
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
            }
            return prefix;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}