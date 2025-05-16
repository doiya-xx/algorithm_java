// 题目编号：231
// 题目标题：2 的幂
// 题目标记：power-of-two

//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：true
//解释：2⁰ = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 16
//输出：true
//解释：2⁴ = 16
// 
//
// 示例 3： 
//
// 
//输入：n = 3
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能够不使用循环/递归解决此问题吗？ 
//
// Related Topics位运算 | 递归 | 数学 
//
// 👍 681, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC00231_PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new LC00231_PowerOfTwo().new Solution();
        int n = 0b100000000000000000;
        boolean res1 = solution.isPowerOfTwo(n);
        System.out.println("res1 = " + res1);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}