// 标题：可被 5 整除的二进制前缀
// 标记：binary-prefix-divisible-by-5
// 编号：1018
// 时间：2024-02-03 21:23:30

//给定一个二进制数组 nums ( 索引从0开始 )。 
//
// 我们将xi 定义为其二进制表示形式为子数组 nums[0..i] (从最高有效位到最低有效位)。 
//
// 
// 例如，如果 nums =[1,0,1] ，那么 x0 = 1, x1 = 2, 和 x2 = 5。 
// 
//
// 返回布尔值列表 answer，只有当 xi 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,1]
//输出：[true,false,false]
//解释：
//输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为 true 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1]
//输出：[false,false,false]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 仅为 0 或 1 
// 
//
// Related Topics 数组 👍 157 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    
    public static void main(String[] args) {
        Solution solution = new BinaryPrefixDivisibleBy5().new Solution();
        System.out.println(solution.prefixesDivBy5(new int[]{0, 1, 1}));
        System.out.println(solution.prefixesDivBy5(new int[]{1, 1, 1}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int prefix = 0;
        for (int num : nums) {
            prefix = ((prefix << 1) + num) % 5;
            res.add(prefix == 0);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}