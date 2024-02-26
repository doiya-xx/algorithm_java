// 标题：子数组的最小值之和
// 标记：sum-of-subarray-minimums
// 编号：907
// 时间：2024-02-14 15:47:51

//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 
//
// Related Topics 栈 数组 动态规划 单调栈 👍 800 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubarrayMinimums {
    
    public static void main(String[] args) {
        Solution solution = new SumOfSubarrayMinimums().new Solution();
        int[] arr = {3, 1, 2, 4};
        System.out.println(solution.sumSubarrayMins(arr));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        long ans = 0;
        // 起点
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            // 终点
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                ans = (ans + min);
            }
        }
        return (int)ans % MOD;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}