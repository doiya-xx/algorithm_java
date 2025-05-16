// 题目编号：93
// 题目标题：复原 IP 地址
// 题目标记：restore-ip-addresses

// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
// 和 "192.168@1.1" 是 无效 IP 地址。
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
// 排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "25525511135"
// 输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
// 输入：s = "0000"
// 输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
// 输入：s = "101023"
// 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics字符串 | 回溯 
//
// 👍 1421, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LC00093_RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new LC00093_RestoreIpAddresses().new Solution();
        List<String> s1 = solution.restoreIpAddresses("25525511135");
        System.out.println("s1 = " + s1);

        List<String> s2 = solution.restoreIpAddresses("0000");
        System.out.println("s2 = " + s2);

        List<String> s3 = solution.restoreIpAddresses("101023");
        System.out.println("s3 = " + s3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int SEG_COUNT = 4;
        List<String> ans = new ArrayList<>();
        int[] segments = new int[SEG_COUNT];

        public List<String> restoreIpAddresses(String s) {
            ans.clear();
            segments = new int[SEG_COUNT];
            _dfs(s, 0, 0);
            return ans;
        }

        public void _dfs(String s, int segId, int idx) {
            int len = s.length();
            if (segId == SEG_COUNT) {
                if (idx == len) {
                    StringBuilder sb = new StringBuilder();
                    for (int segment : segments) {
                        sb.append(segment).append(".");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    ans.add(sb.toString());
                }
                return;
            }

            if (idx == len) {
                return;
            }

            for (int i = 1; idx + i <= len; i++) {
                int add = Integer.parseInt(s.substring(idx, idx + i));
                if (add >= 0 && add <= 255) {
                    segments[segId] = add;
                    _dfs(s, segId + 1, idx + i);
                    if (add == 0) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}