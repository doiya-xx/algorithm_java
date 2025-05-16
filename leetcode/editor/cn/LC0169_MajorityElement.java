/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == nums.length
 * 1 <= n <= 5 * 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * Related Topics 数组 哈希表 分治 计数 排序 👍 2487 👎 0
 */

package leetcode.editor.cn;

public class LC0169_MajorityElement {

    public static void main(String[] args) {
        Solution solution = new LC0169_MajorityElement().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // 投票决策思路
            int cand_num = nums[0], count = 1;
            for (int i = 1; i < nums.length; ++i) {
                if (cand_num == nums[i])
                    ++count;
                else if (--count == 0) {
                    cand_num = nums[i];
                    count = 1;
                }
            }
            return cand_num;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


}