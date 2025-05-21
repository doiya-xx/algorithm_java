/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,0,1,2]
 * 输出：3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 并查集 数组 哈希表 👍 2502 👎 0
 */

package leetcode.editor.cn;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LC0128_LongestConsecutiveSequence {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            int max = 0;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            for (int x : set) {
                if (set.contains(x - 1)) {
                    continue;
                }
                int y = x + 1;
                while (set.contains(y)) {
                    y++;
                }
                max = Math.max(max, y - x);
            }
            return max;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {
        public int longestConsecutive(int[] nums) {
            int max = 0;

            return max;
        }
    }
}