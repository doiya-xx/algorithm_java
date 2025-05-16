// 题目编号：3115
// 题目标题：质数的最大距离
// 题目标记：maximum-prime-difference

//给你一个整数数组 nums。 
//
// 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [4,2,9,5,3] 
// 
//
// 输出： 3 
//
// 解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。 
//
// 示例 2： 
//
// 
// 输入： nums = [4,8,2,8] 
// 
//
// 输出： 0 
//
// 解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁵ 
// 1 <= nums[i] <= 100 
// 输入保证 nums 中至少有一个质数。 
// 
//
// Related Topics数组 | 数学 | 数论 
//
// 👍 11, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC03115_MaximumPrimeDifference {
    public static void main(String[] args) {
        Solution solution = new LC03115_MaximumPrimeDifference().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumPrimeDifference(int[] nums) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(
                2, 3, 5, 7, 11,
                13, 17, 19, 23, 29,
                31, 37, 41, 43, 47,
                53, 59, 61, 67, 71,
                73, 79, 83, 89, 97
        ));

        int n = nums.length;
        int first = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (primes.contains(nums[i])) {
                if (first != -1) {
                    ans = Math.max(ans, i - first);
                } else {
                    first = i;
                }
            }
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}