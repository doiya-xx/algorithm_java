// 题目编号：70
// 题目标题：爬楼梯
// 题目标记：climbing-stairs

// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 2
// 输出：2
// 解释：有两种方法可以爬到楼顶。
// 1. 1 阶 + 1 阶
// 2. 2 阶
//
// 示例 2： 
//
// 
// 输入：n = 3
// 输出：3
// 解释：有三种方法可以爬到楼顶。
// 1. 1 阶 + 1 阶 + 1 阶
// 2. 1 阶 + 2 阶
// 3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics记忆化搜索 | 数学 | 动态规划 
//
// 👍 3531, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC00070_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new LC00070_ClimbingStairs().new Solution();
        int res1 = solution.climbStairs(4);
        System.out.println("res1 = " + res1);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public int climbStairs(int n) {
            double sqrt5 = Math.sqrt(5);
            double fibn = Math.pow((1.0 + sqrt5) / 2, n + 1) - Math.pow((1.0 - sqrt5) / 2, n + 1);
            return (int) Math.round(fibn / sqrt5);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

    public class Solution2 {
        public int climbStairs(int n) {
            int[][] q = {{1, 1}, {1, 0}};
            int[][] res = pow(q, n);
            return res[0][0];
        }

        public int[][] pow(int[][] a, int n) {
            int[][] ret = {{1, 0}, {0, 1}};
            while (n > 0) {
                if ((n & 1) == 1) {
                    ret = multiply(ret, a);
                }
                n >>= 1;
                a = multiply(a, a);
            }
            return ret;
        }

        public int[][] multiply(int[][] a, int[][] b) {
            int[][] c = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
                }
            }
            return c;
        }
    }

}