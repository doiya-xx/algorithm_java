// 题目编号：1103
// 题目标题：分糖果 II
// 题目标记：distribute-candies-to-people

//<p>排排坐，分糖果。</p>
//
//<p>我们买了一些糖果 <code>candies</code>，打算把它们分给排好队的 <strong><code>n = num_people</code></strong> 个小朋友。</p>
//
//<p>给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 <code>n</code>&nbsp;颗糖果。</p>
//
//<p>然后，我们再回到队伍的起点，给第一个小朋友 <code>n&nbsp;+ 1</code> 颗糖果，第二个小朋友 <code>n&nbsp;+ 2</code> 颗，依此类推，直到给最后一个小朋友 <code>2 * n</code>&nbsp;颗糖果。</p>
//
//<p>重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。</p>
//
//<p>返回一个长度为 <code>num_people</code>、元素之和为 <code>candies</code> 的数组，以表示糖果的最终分发情况（即 <code>ans[i]</code> 表示第 <code>i</code> 个小朋友分到的糖果数）。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>candies = 7, num_people = 4
//<strong>输出：</strong>[1,2,3,1]
//<strong>解释：</strong>
// 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
// 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
// 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
// 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>candies = 10, num_people = 3
//<strong>输出：</strong>[5,2,3]
//<strong>解释：</strong>
// 第一次，ans[0] += 1，数组变为 [1,0,0]。
// 第二次，ans[1] += 2，数组变为 [1,2,0]。
// 第三次，ans[2] += 3，数组变为 [1,2,3]。
// 第四次，ans[0] += 4，最终数组变为 [5,2,3]。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= candies &lt;= 10^9</code></li> 
// <li><code>1 &lt;= num_people &lt;= 1000</code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数学 | 模拟</details><br>
//
//<div>👍 149, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
//
//
//
//

package leetcode.editor.cn;

import java.util.Arrays;

public class LC01103_DistributeCandiesToPeople {
    public static void main(String[] args) {
        Solution solution = new LC01103_DistributeCandiesToPeople().new Solution();
        int[] res = solution.distributeCandies(10, 3);
        System.out.println(Arrays.toString(res));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            // int count = 2*candies;
            // int k = 1;
            // while (k * (1 + k) <= count) {
            //     k++;
            // }
            // int n = k-1;
            // int r = (n+num_people-1)/num_people;
            int[] ans = new int[num_people];
            int i = 0;
            while (candies != 0) {
                ans[i % num_people] += Math.min(candies, i + 1);
                candies -= Math.min(candies, i + 1);
                i += 1;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}