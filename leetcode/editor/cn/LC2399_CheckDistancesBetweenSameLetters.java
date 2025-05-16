/**
 * 给你一个下标从 0 开始的字符串 s ，该字符串仅由小写英文字母组成，s 中的每个字母都 恰好 出现 两次 。另给你一个下标从 0 开始、长度为 26 的的整数
 * 数组 distance 。
 * <p>
 * 字母表中的每个字母按从 0 到 25 依次编号（即，'a' -> 0, 'b' -> 1, 'c' -> 2, ... , 'z' -> 25）。
 * <p>
 * 在一个 匀整 字符串中，第 i 个字母的两次出现之间的字母数量是 distance[i] 。如果第 i 个字母没有在 s 中出现，那么 distance[i]
 * 可以 忽略 。
 * <p>
 * 如果 s 是一个 匀整 字符串，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abaccb", distance = [1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
 * 0]
 * 输出：true
 * 解释：
 * - 'a' 在下标 0 和下标 2 处出现，所以满足 distance[0] = 1 。
 * - 'b' 在下标 1 和下标 5 处出现，所以满足 distance[1] = 3 。
 * - 'c' 在下标 3 和下标 4 处出现，所以满足 distance[2] = 0 。
 * 注意 distance[3] = 5 ，但是由于 'd' 没有在 s 中出现，可以忽略。
 * 因为 s 是一个匀整字符串，返回 true 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "aa", distance = [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：false
 * 解释：
 * - 'a' 在下标 0 和 1 处出现，所以两次出现之间的字母数量为 0 。
 * 但是 distance[0] = 1 ，s 不是一个匀整字符串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= s.length <= 52
 * s 仅由小写英文字母组成
 * s 中的每个字母恰好出现两次
 * distance.length == 26
 * 0 <= distance[i] <= 50
 * <p>
 * <p>
 * Related Topics 数组 哈希表 字符串 👍 70 👎 0
 */

package leetcode.editor.cn;

public class LC2399_CheckDistancesBetweenSameLetters {

    public static void main(String[] args) {
        Solution solution = new LC2399_CheckDistancesBetweenSameLetters().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkDistances(String s, int[] distance) {
            short[] flag = new short[26];
            for (short i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                short j = (short) (c - 'a');
                if (flag[j] == 0) {
                    flag[j] = 1;
                    if (distance[j] != (short) (s.lastIndexOf(c) - i - 1)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


}