// 标题：石子游戏 VII
// 标记：stone-game-vii
// 编号：1690
// 时间：2024-02-03 21:27:15

// 石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。
//
// 有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得
// 分较高者获胜。
//
// 鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。 
//
// 给你一个整数数组 stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分
// 的差值 。
//
// 
//
// 示例 1： 
//
// 
// 输入：stones = [5,3,1,4,2]
// 输出：6
// 解释：
//- 爱丽丝移除 2 ，得分 5 + 3 + 1 + 4 = 13 。游戏情况：爱丽丝 = 13 ，鲍勃 = 0 ，石子 = [5,3,1,4] 。
//- 鲍勃移除 5 ，得分 3 + 1 + 4 = 8 。游戏情况：爱丽丝 = 13 ，鲍勃 = 8 ，石子 = [3,1,4] 。
//- 爱丽丝移除 3 ，得分 1 + 4 = 5 。游戏情况：爱丽丝 = 18 ，鲍勃 = 8 ，石子 = [1,4] 。
//- 鲍勃移除 1 ，得分 4 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [4] 。
//- 爱丽丝移除 4 ，得分 0 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [] 。
// 得分的差值 18 - 12 = 6 。
// 
//
// 示例 2： 
//
// 
// 输入：stones = [7,90,5,1,100,10,10,2]
// 输出：122
//
// 
//
// 提示： 
//
// 
// n == stones.length 
// 2 <= n <= 1000 
// 1 <= stones[i] <= 1000 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 121 👎 0


package leetcode.editor.cn;

public class StoneGameVii {
    
    public static void main(String[] args) {
        Solution solution = new StoneGameVii().new Solution();
        System.out.println(solution.stoneGameVII(new int[]{5, 3, 1, 4, 2}));
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int stoneGameVII(int[] stones) {
            int n = stones.length; // 获取石子数组的长度
            int[] preSum = new int[n + 1]; // 初始化前缀和数组，长度为石子数组长度+1
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + stones[i - 1]; // 计算前缀和数组，preSum[i]表示stones数组前i个元素的和
            }
            int[][] dp = new int[n][n]; // 初始化动态规划数组，dp[i][j]表示在stones[i...j]中，当前玩家与另一玩家的最大得分差
            for (int len = 2; len <= n; len++) { // len表示考虑的石子序列长度
                for (int i = 0; i + len - 1 < n; i++) { // i表示石子序列的起始位置
                    int j = i + len - 1; // j表示石子序列的结束位置
                    // dp[i][j]的值由两部分取最大值，一部分是移除最左边的石头后的最大得分差，另一部分是移除最右边的石头后的最大得分差
                    dp[i][j] = Math.max(preSum[j + 1] - preSum[i + 1] - dp[i + 1][j], preSum[j] - preSum[i] - dp[i][j - 1]);
                }
            }
            return dp[0][n - 1]; // 返回在stones[0...n-1]中，当前玩家与另一玩家的最大得分差
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
    
}