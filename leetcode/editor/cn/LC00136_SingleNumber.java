// 题目编号：136
// 题目标题：只出现一次的数字
// 题目标记：single-number

//给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。 
//
// 
// 
// 
// 
// 
//
// 示例 1 ： 
//
// 
//输入：nums = [2,2,1]
//输出：1
// 
//
// 示例 2 ： 
//
// 
//输入：nums = [4,1,2,1,2]
//输出：4
// 
//
// 示例 3 ： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 除了某个元素只出现一次以外，其余每个元素均出现两次。 
// 
//
// Related Topics位运算 | 数组 
//
// 👍 3164, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC00136_SingleNumber {
    public static void main(String[] args) {
        Solution solution = new LC00136_SingleNumber().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}