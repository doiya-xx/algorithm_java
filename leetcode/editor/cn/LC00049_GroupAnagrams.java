// 题目编号：49
// 题目标题：字母异位词分组
// 题目标记：group-anagrams

// 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
// 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
// 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// 示例 2: 
//
// 
// 输入: strs = [""]
// 输出: [[""]]
// 
//
// 示例 3: 
//
// 
// 输入: strs = ["a"]
// 输出: [["a"]]
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics数组 | 哈希表 | 字符串 | 排序 
//
// 👍 1909, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LC00049_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new LC00049_GroupAnagrams().new Solution();
        List<List<String>> lists1 = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println("lists = " + lists1);

        // List<List<String>> lists2 = solution.groupAnagrams(new String[]{""});
        // System.out.println("lists = " + lists2);
        //
        // List<List<String>> lists3 = solution.groupAnagrams(new String[]{"a"});
        // System.out.println("lists = " + lists3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // Map<String, List<String>> map = new HashMap<>();
            // for (String str : strs) {
            //     String key = str.chars().sorted().mapToObj(String::valueOf).collect(Collectors.joining());
            //     map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            // }
            Map<String, List<String>> map = Arrays.stream(strs).collect(Collectors.groupingBy(str ->
                    str.chars().sorted().mapToObj(String::valueOf).collect(Collectors.joining())
                    // str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()
            ));
            return new ArrayList<>(map.values());
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}