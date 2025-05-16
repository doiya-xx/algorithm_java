// 题目编号：125
// 题目标题：验证回文串
// 题目标记：valid-palindrome

//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。 
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s 仅由可打印的 ASCII 字符组成 
// 
//
// Related Topics双指针 | 字符串 
//
// 👍 748, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC00125_ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new LC00125_ValidPalindrome().new Solution();
        boolean palindrome1 = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("palindrome1 = " + palindrome1);
        boolean palindrome2 = solution.isPalindrome("race a car");
        System.out.println("palindrome2 = " + palindrome2);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z]", "");
        if (s.isEmpty()) {
            return true;
        }
        String rs = new StringBuffer(s).reverse().toString();
        return rs.equals(s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}