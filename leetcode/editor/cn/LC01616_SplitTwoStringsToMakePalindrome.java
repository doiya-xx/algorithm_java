// 题目编号：1616
// 题目标题：分割两个字符串得到回文串
// 题目标记：split-two-strings-to-make-palindrome

//给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 
//asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = 
//bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。 
//
// 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么
// "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。 
//
// 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。 
//
// 注意， x + y 表示连接字符串 x 和 y 。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = "x", b = "y"
//输出：true
//解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
//aprefix = "", asuffix = "x"
//bprefix = "", bsuffix = "y"
//那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：a = "abdef", b = "fecab"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：a = "ulacfd", b = "jizalu"
//输出：true
//解释：在下标为 3 处分割：
//aprefix = "ula", asuffix = "cfd"
//bprefix = "jiz", bsuffix = "alu"
//那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁵ 
// a.length == b.length 
// a 和 b 都只包含小写英文字母 
// 
//
// Related Topics双指针 | 字符串 
//
// 👍 154, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC01616_SplitTwoStringsToMakePalindrome {
    public static void main(String[] args) {
        Solution solution = new LC01616_SplitTwoStringsToMakePalindrome().new Solution();
        boolean b = solution.checkPalindromeFormation("abdef", "fecab");
        System.out.println("b = " + b);
        boolean b1 = solution.checkPalindromeFormation("ulacfd", "jizalu");
        System.out.println("b1 = " + b1);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        if (isPalindrome(a) || isPalindrome(b)) {
            return true;
        }
        int length = a.length();
        int i = 1;
        while (i != length) {
            String a_l = a.substring(0, i);
            String a_r = a.substring(i);
            String b_l = b.substring(0, i);
            String b_r = b.substring(i);

            if (isPalindrome(a_l + b_r) || isPalindrome(b_l + a_r)) {
                System.out.println(a_l + b_r);
                System.out.println(b_l + a_r);
                return true;
            }
            i++;
        }
        return false;
    }

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