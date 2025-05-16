// 题目编号：53
// 题目标题：最大子数组和
// 题目标记：maximum-subarray

// 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
// 输出：6
// 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1]
// 输出：1
// 
//
// 示例 3： 
//
// 
// 输入：nums = [5,4,-1,7,8]
// 输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics数组 | 分治 | 动态规划 
//
// 👍 6683, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC00053_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new LC00053_MaximumSubarray().new Solution();
        int i1 = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("i1 = " + i1);

        int i2 = solution.maxSubArray(new int[]{5, 4, -1, 7, 8});
        System.out.println("i2 = " + i2);

        int i3 = solution.maxSubArray(new int[]{1});
        System.out.println("i3 = " + i3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {
        public class Status {
            public int lSum, rSum, mSum, iSum;

            public Status(int lSum, int rSum, int mSum, int iSum) {
                this.lSum = lSum;
                this.rSum = rSum;
                this.mSum = mSum;
                this.iSum = iSum;
            }
        }

        public int maxSubArray(int[] nums) {
            return getInfo(nums, 0, nums.length - 1).mSum;
        }

        public Status getInfo(int[] a, int l, int r) {
            if (l == r) {
                return new Status(a[l], a[l], a[l], a[l]);
            }
            int m = (l + r) >> 1;
            Status lSub = getInfo(a, l, m);
            Status rSub = getInfo(a, m + 1, r);
            return pushUp(lSub, rSub);
        }

        public Status pushUp(Status l, Status r) {
            int iSum = l.iSum + r.iSum;
            int lSum = Math.max(l.lSum, l.iSum + r.lSum);
            int rSum = Math.max(r.rSum, r.iSum + l.rSum);
            int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
            return new Status(lSum, rSum, mSum, iSum);
        }
    }


}