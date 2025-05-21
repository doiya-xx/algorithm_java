/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= strs.length <= 10⁴
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * <p>
 * <p>
 * Related Topics 数组 哈希表 字符串 排序 👍 2269 👎 0
 */

package leetcode.editor.cn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.stream.Collectors;


public class LC0049_GroupAnagrams {

    @Test
    public void testSolution() {
        // 输入
        // {"eat", "tea", "tan", "ate", "nat", "bat"}
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // 输出
        // {{"bat"},{"nat","tan"},{"ate","eat","tea"}}
        Set<Set<String>> expect = Set.of(
                Set.of("bat"),
                Set.of("nat", "tan"),
                Set.of("ate", "eat", "tea")
        );
        // 测试
        Solution solution = new Solution();
        Set<Set<String>> actual1 = solution.groupAnagrams(strs).stream().map(HashSet::new).collect(Collectors.toSet());
        Assertions.assertEquals(expect, actual1);

        // Solution2 solution2 = new Solution2();
        // Set<Set<String>> actual2 = solution2.groupAnagrams(strs).stream().map(HashSet::new).collect(Collectors.toSet());
        // Assertions.assertEquals(expect, actual2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 时间复杂度：O(nklogk)
         * 空间复杂度：O(nk)
         *
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] count = new char[26];
                for (char c : str.toCharArray()) {
                    count[c - 'a']++;
                }
                String key = new String(count);
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}