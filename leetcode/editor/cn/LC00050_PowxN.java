// 题目编号：50
// 题目标题：Pow(x, n)
// 题目标记：powx-n

// 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xⁿ ）。
//
// 
//
// 示例 1： 
//
// 
// 输入：x = 2.00000, n = 10
// 输出：1024.00000
// 
//
// 示例 2： 
//
// 
// 输入：x = 2.10000, n = 3
// 输出：9.26100
// 
//
// 示例 3： 
//
// 
// 输入：x = 2.00000, n = -2
// 输出：0.25000
// 解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// n 是一个整数 
// 要么 x 不为零，要么 n > 0 。 
// -104 <= xⁿ <= 104 
// 
//
// Related Topics递归 | 数学 
//
// 👍 1347, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC00050_PowxN {
    public static void main(String[] args) {
        Solution solution = new LC00050_PowxN().new Solution();
        System.out.println(solution.myPow(2, -3));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n == Integer.MIN_VALUE)
                return (x == 1 || x == -1) ? 1 : 0;
            else if (n == 0)
                return 1;

            if (n < 0)
                return myPow(1 / x, -n);
            if (n % 2 == 0)
                return myPow(x * x, n / 2);
            else
                return myPow(x, n - 1) * x;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}