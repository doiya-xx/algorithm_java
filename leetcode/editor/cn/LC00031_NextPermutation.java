// 题目编号：31
// 题目标题：下一个排列
// 题目标记：next-permutation

// 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
// 是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3]
// 输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
// 输入：nums = [3,2,1]
// 输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
// 输入：nums = [1,1,5]
// 输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics数组 | 双指针 
//
// 👍 2502, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

public class LC00031_NextPermutation {
    public static void main(String[] args) {
        Solution solution = new LC00031_NextPermutation().new Solution();
        int[] nums1 = {4, 1, 2, 5, 4, 3, 1};
        int[] nums2 = {4,5,2,6,3,1};

        solution.nextPermutation(nums1);
        solution.nextPermutation(nums2);

        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int length = nums.length;
            int i = length - 1;
            while (i > 0 && nums[i - 1] >= nums[i]) {
                i--;
            }
            if (i != 0) {
                int j = length - 1;
                while (nums[j] <= nums[i - 1]) {
                    j--;
                }
                int t = nums[i - 1];
                nums[i - 1] = nums[j];
                nums[j] = t;
            }
            int[] sortedArray = Arrays.stream(Arrays.copyOfRange(nums, i, length)).sorted().toArray();
            System.arraycopy(sortedArray, 0, nums, i, length - i);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}