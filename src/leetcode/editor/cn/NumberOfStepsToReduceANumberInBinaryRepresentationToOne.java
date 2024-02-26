// 标题：将二进制表示减到 1 的步骤数
// 标记：number-of-steps-to-reduce-a-number-in-binary-representation-to-one
// 编号：1404
// 时间：2024-02-14 16:44:50

// 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
//
// 
// 如果当前数字为偶数，则将其除以 2 。 
// 如果当前数字为奇数，则将其加上 1 。 
// 
//
// 题目保证你总是可以按上述规则将测试用例变为 1 。 
//
// 
//
// 示例 1： 
//
// 输入：s = "1101"
// 输出：6
// 解释："1101" 表示十进制数 13 。
// Step 1) 13 是奇数，加 1 得到 14 
// Step 2) 14 是偶数，除 2 得到 7
// Step 3) 7  是奇数，加 1 得到 8
// Step 4) 8  是偶数，除 2 得到 4 
// Step 5) 4  是偶数，除 2 得到 2 
// Step 6) 2  是偶数，除 2 得到 1 
// 
//
// 示例 2： 
//
// 输入：s = "10"
// 输出：1
// 解释："10" 表示十进制数 2 。
// Step 1) 2 是偶数，除 2 得到 1
// 
//
// 示例 3： 
//
// 输入：s = "1"
// 输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 由字符 '0' 或 '1' 组成。 
// s[0] == '1' 
// 
//
// Related Topics 位运算 字符串 👍 49 👎 0


package leetcode.editor.cn;

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    
    public static void main(String[] args) {
        Solution solution = new NumberOfStepsToReduceANumberInBinaryRepresentationToOne().new Solution();
        System.out.println(solution.numSteps("1101"));
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSteps(String s) {
            int count = 0;
            int carry = 0;
            for (int i = s.length() - 1; i > 0; i--) {
                count++;
                if (s.charAt(i) - '0' + carry == 1) {
                    carry = 1;
                    count++;
                }
            }
            return count + carry;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
    
}