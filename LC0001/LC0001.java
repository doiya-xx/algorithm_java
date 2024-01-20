package LC0001;

import java.util.HashMap;

/*
Leetcode 0001 两数之和
 */

class Solution {
    /**
     * 在给定的整数数组中找到两个数，使得它们的和等于给定的目标值。
     *
     * @param nums   给定的整数数组
     * @param target 给定的目标值
     * @return 返回一个包含两个索引的数组，这两个索引对应的元素之和等于目标值
     */
    public int[] twoSum(int[] nums, int target) {
        // 创建一个哈希映射来存储数组中的每个元素和它的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        // 创建一个数组来存储结果
        int[] ret = new int[2];
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 获取当前元素
            int num = nums[i];
            // 计算目标值与当前元素的差
            int diff = target - num;
            // 在哈希映射中查找这个差值
            if (map.containsKey(diff)) {
                // 如果找到了，就返回这两个元素的索引
                ret[0] = map.get(diff);
                ret[1] = i;
                return ret;
            }
            // 如果没有找到，就将当前元素和它的索引添加到哈希映射中
            map.put(num, i);
        }
        // 如果遍历完数组都没有找到，就返回结果数组
        return ret;
    }
}

public class LC0001 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 5};
        int target = 9;
        int[] ret = solution.twoSum(nums, target);
        System.out.println(ret[0] + " " + ret[1]);
    }
}
