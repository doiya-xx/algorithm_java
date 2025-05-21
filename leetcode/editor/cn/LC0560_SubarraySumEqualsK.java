/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 2 * 10⁴
 * -1000 <= nums[i] <= 1000
 * -10⁷ <= k <= 10⁷
 * <p>
 * <p>
 * Related Topics 数组 哈希表 前缀和 👍 2764 👎 0
 */

package leetcode.editor.cn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class LC0560_SubarraySumEqualsK {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0, pre = 0;
            Map<Integer, Integer> mp = new HashMap<>();
            mp.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                // if (mp.containsKey(pre - k)) {
                //     count += mp.get(pre - k);
                // }
                count += mp.getOrDefault(pre-k, 0);
                // 键不存在，插入1；键处在，旧值和固定新值相加
                // mp.put(pre, mp.getOrDefault(pre, 0) + 1);
                // mp.compute(pre, (key, value) -> (value == null) ? 1 : value+1);
                mp.merge(pre, 1, Integer::sum);
            }
            return count;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}