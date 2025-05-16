/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：[3]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 5 * 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * <p>
 * Related Topics 数组 哈希表 计数 排序 👍 761 👎 0
 */

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LC0229_MajorityElementIi {

    public static void main(String[] args) {
        Solution solution = new LC0229_MajorityElementIi().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int n = nums.length;
            int candidate1 = 0, candidate2 = 0;
            int count1 = 0, count2 = 0;

            for (int num : nums) {
                if (num == candidate1) {
                    count1++;
                } else if (num == candidate2) {
                    count2++;
                } else if (count1 == 0) {
                    candidate1 = num;
                    count1 = 1;
                } else if (count2 == 0) {
                    candidate2 = num;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }

            count1 = 0;
            count2 = 0;
            for (int num : nums) {
                if (num == candidate1) {
                    count1++;
                } else if (num == candidate2) {
                    count2++;
                }
            }

            List<Integer> res = new ArrayList<>();
            if (count1 > n / 3) {
                res.add(candidate1);
            }
            if (count2 > n / 3) {
                res.add(candidate2);
            }

            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


}