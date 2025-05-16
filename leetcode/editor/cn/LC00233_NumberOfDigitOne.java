// 题目编号：233
// 题目标题：数字 1 的个数
// 题目标记：number-of-digit-one

//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics递归 | 数学 | 动态规划 
//
// 👍 581, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC00233_NumberOfDigitOne {
    public static void main(String[] args) {
        Solution solution = new LC00233_NumberOfDigitOne().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (int) ((n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk));
            mulk *= 10;
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}