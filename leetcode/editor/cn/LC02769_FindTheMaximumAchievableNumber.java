// 题目编号：2769
// 题目标题：找出最大的可达成数字
// 题目标记：find-the-maximum-achievable-number

//给你两个整数 num 和 t 。 
//
// 如果整数 x 可以在执行下述操作不超过 t 次的情况下变为与 num 相等，则称其为 可达成数字 ： 
//
// 
// 每次操作将 x 的值增加或减少 1 ，同时可以选择将 num 的值增加或减少 1 。 
// 
//
// 返回所有可达成数字中的最大值。可以证明至少存在一个可达成数字。 
//
// 
//
// 示例 1： 
//
// 输入：num = 4, t = 1
//输出：6
//解释：最大可达成数字是 x = 6 ，执行下述操作可以使其等于 num ：
//- x 减少 1 ，同时 num 增加 1 。此时，x = 5 且 num = 5 。 
//可以证明不存在大于 6 的可达成数字。
// 
//
// 示例 2： 
//
// 输入：num = 3, t = 2
//输出：7
//解释：最大的可达成数字是 x = 7 ，执行下述操作可以使其等于 num ：
//- x 减少 1 ，同时 num 增加 1 。此时，x = 6 且 num = 4 。 
//- x 减少 1 ，同时 num 增加 1 。此时，x = 5 且 num = 5 。 
//可以证明不存在大于 7 的可达成数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num, t <= 50 
// 
//
// Related Topics数学 
//
// 👍 41, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC02769_FindTheMaximumAchievableNumber {
    public static void main(String[] args) {
        Solution solution = new LC02769_FindTheMaximumAchievableNumber().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}