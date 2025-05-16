// 题目编号：78
// 题目标题：子集
// 题目标记：subsets

// 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3]
// 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
// 输入：nums = [0]
// 输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 2301, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LC00078_Subsets {
    public static void main(String[] args) {
        Solution solution = new LC00078_Subsets().new Solution();
        List<List<Integer>> res1 = solution.subsets(new int[]{1, 2, 3});
        System.out.println("res1 = " + res1);

        List<List<Integer>> res2 = solution.subsets(new int[]{0});
        System.out.println("res2 = " + res2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = i; j < n; j++) {
                    list.add(nums[j]);
                    ans.add(new ArrayList<>(list));
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            return ans;
        }

        public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                ans.add(new ArrayList<>(t));
                return;
            }
            t.add(nums[cur]);
            dfs(cur + 1, nums);
            t.remove(t.size() - 1);
            dfs(cur + 1, nums);
        }
    }
}