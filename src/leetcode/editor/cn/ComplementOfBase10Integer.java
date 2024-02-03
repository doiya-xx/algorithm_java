// 标题：十进制整数的反码
// 标记：complement-of-base-10-integer
// 编号：1009
// 时间：2024-02-03 22:43:12

// 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，
// 任何二进制表示中都不含前导零。
//
// 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。 
//
// 给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：5
// 输出：2
// 解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
// 
//
// 示例 2： 
//
// 输入：7
// 输出：0
// 解释：7 的二进制表示为 "111"，其二进制反码为 "000"，也就是十进制中的 0 。
// 
//
// 示例 3： 
//
// 输入：10
// 输出：5
// 解释：10 的二进制表示为 "1010"，其二进制反码为 "0101"，也就是十进制中的 5 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= N < 10^9 
// 本题与 476：https://leetcode-cn.com/problems/number-complement/ 相同 
// 
//
// Related Topics 位运算 👍 100 👎 0


package leetcode.editor.cn;

import java.nio.ByteBuffer;

public class ComplementOfBase10Integer {
    
    public static void main(String[] args) {
        Solution solution = new ComplementOfBase10Integer().new Solution();
        System.out.println(solution.bitwiseComplement(10));
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bitwiseComplement(int n) {
            // 如果输入的整数n为0，直接返回1，因为0的二进制反码为1
            if (n == 0) {
                return 1;
            }
            
            // 初始化一个掩码mask，其值为2的30次方，即二进制表示为1后面跟30个0
            int mask = 1 << 30;
            
            // 当n与mask进行位与运算的结果为0时，将mask右移一位
            // 这个循环的目的是找到n的最高位1的位置
            while ((n & mask) == 0) {
                mask >>= 1;
            }
            
            // 将mask左移一位后减1，得到的新mask的二进制表示为n的最高位1及其以下的所有位都为1
            mask = (mask << 1) - 1;
            
            // n与新mask进行位异或运算，得到的结果就是n的二进制反码所对应的十进制整数
            return n ^ mask;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
    
}