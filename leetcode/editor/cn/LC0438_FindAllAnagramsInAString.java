/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= s.length, p.length <= 3 * 10⁴
 * s 和 p 仅包含小写字母
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 1678 👎 0
 */

package leetcode.editor.cn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class LC0438_FindAllAnagramsInAString {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            int[] cnt = new int[26]; // 统计 p 的每种字母的出现次数
            for (char c : p.toCharArray()) {
                cnt[c - 'a']++;
            }
            for (int left = 0, right = 0; right < s.length(); right++) {
                int c = s.charAt(right) - 'a';
                cnt[c]--; // 右端点字母进入窗口
                while (cnt[c] < 0) { // 字母 c 太多了
                    cnt[s.charAt(left) - 'a']++; // 左端点字母离开窗口
                    left++;
                }
                if (right - left + 1 == p.length()) { // s' 和 p 的每种字母的出现次数都相同
                    ans.add(left); // s' 左端点下标加入答案
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}