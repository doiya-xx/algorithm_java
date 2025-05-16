// 题目编号：42
// 题目标题：接雨水
// 题目标记：trapping-rain-water

//<p>给定&nbsp;<code>n</code> 个非负整数表示每个宽度为 <code>1</code> 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png" style="height: 161px; width: 412px;" /></p>
//
//<pre>
//<strong>输入：</strong>height = [0,1,0,2,1,0,1,3,2,1,2,1]
//<strong>输出：</strong>6
//<strong>解释：</strong>上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>height = [4,2,0,3,2,5]
//<strong>输出：</strong>9
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>n == height.length</code></li> 
// <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li> 
// <li><code>0 &lt;= height[i] &lt;= 10<sup>5</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 双指针 | 动态规划 | 单调栈</details><br>
//
//<div>👍 5179, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
//
//
//
//

package leetcode.editor.cn;

public class LC00042_TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new LC00042_TrappingRainWater().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int l_max = 0, r_max = 0, ans = 0;
            for (int i = 0; i < height.length; i++) {
                l_max = Math.max(l_max, height[i]);
                r_max = Math.max(r_max, height[height.length - i - 1]);
                ans += l_max + r_max - height[i];
            }
            return ans - l_max * height.length;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}