// 题目编号：2806
// 题目标题：取整购买后的账户余额
// 题目标记：account-balance-after-rounded-purchase

//一开始，你的银行账户里有 100 块钱。 
//
// 给你一个整数purchaseAmount ，它表示你在一次购买中愿意支出的金额。 
//
// 在一个商店里，你进行一次购买，实际支出的金额会向 最近 的 10 的 倍数 取整。换句话说，你实际会支付一个 非负 金额 roundedAmount ，满
//足 roundedAmount 是 10 的倍数且 abs(roundedAmount - purchaseAmount) 的值 最小 。 
//
// 如果存在多于一个最接近的 10 的倍数，较大的倍数 是你的实际支出金额。 
//
// 请你返回一个整数，表示你在愿意支出金额为 purchaseAmount 块钱的前提下，购买之后剩下的余额。 
//
// 注意： 0 也是 10 的倍数。 
//
// 
//
// 示例 1： 
//
// 输入：purchaseAmount = 9
//输出：90
//解释：这个例子中，最接近 9 的 10 的倍数是 10 。所以你的账户余额为 100 - 10 = 90 。
// 
//
// 示例 2： 
//
// 输入：purchaseAmount = 15
//输出：80
//解释：这个例子中，有 2 个最接近 15 的 10 的倍数：10 和 20，较大的数 20 是你的实际开销。
//所以你的账户余额为 100 - 20 = 80 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= purchaseAmount <= 100 
// 
//
// Related Topics数学 
//
// 👍 22, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

public class LC02806_AccountBalanceAfterRoundedPurchase {
    public static void main(String[] args) {
        Solution solution = new LC02806_AccountBalanceAfterRoundedPurchase().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}