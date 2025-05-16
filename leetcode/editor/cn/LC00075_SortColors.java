// 题目编号：75
// 题目标题：颜色分类
// 题目标记：sort-colors

// 给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [2,0,2,1,1,0]
// 输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
// 输入：nums = [2,0,1]
// 输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 1783, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

public class LC00075_SortColors {
    public static void main(String[] args) {
        Solution solution = new LC00075_SortColors().new Solution();
        int[] ints1 = {2, 0, 2, 1, 1, 0};
        solution.sortColors(ints1);
        System.out.println("ints1 = " + Arrays.toString(ints1));

        int[] ints2 = {2, 0, 1};
        solution.sortColors(ints2);
        System.out.println("ints1 = " + Arrays.toString(ints2));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            int p0 = 0, p2 = n - 1;
            for (int i = 0; i <= p2; ++i) {
                while (i <= p2 && nums[i] == 2) {
                    int temp = nums[i];
                    nums[i] = nums[p2];
                    nums[p2] = temp;
                    --p2;
                }
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = temp;
                    ++p0;
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}