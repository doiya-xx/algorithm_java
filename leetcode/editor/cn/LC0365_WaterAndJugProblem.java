/**
 * 有两个水壶，容量分别为 x 和 y 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 target 升。
 * <p>
 * 你可以：
 * <p>
 * <p>
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 将水从一个水壶倒入另一个水壶，直到接水壶已满，或倒水壶已空。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: x = 3,y = 5,target = 4
 * 输出: true
 * 解释：
 * 按照以下步骤操作，以达到总共 4 升水：
 * 1. 装满 5 升的水壶(0, 5)。
 * 2. 把 5 升的水壶倒进 3 升的水壶，留下 2 升(3, 2)。
 * 3. 倒空 3 升的水壶(0, 2)。
 * 4. 把 2 升水从 5 升的水壶转移到 3 升的水壶(2, 0)。
 * 5. 再次加满 5 升的水壶(2, 5)。
 * 6. 从 5 升的水壶向 3 升的水壶倒水直到 3 升的水壶倒满。5 升的水壶里留下了 4 升水(3, 4)。
 * 7. 倒空 3 升的水壶。现在，5 升的水壶里正好有 4 升水(0, 4)。
 * 参考：来自著名的 "Die Hard"
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: x = 2, y = 6, target = 5
 * 输出: false
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: x = 1, y = 2, target = 3
 * 输出: true
 * 解释：同时倒满两个水壶。现在两个水壶中水的总量等于 3。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= x, y, target <= 10³
 * <p>
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 数学 👍 553 👎 0
 */

package leetcode.editor.cn;

public class LC0365_WaterAndJugProblem {

    public static void main(String[] args) {
        Solution solution = new LC0365_WaterAndJugProblem().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            if (x + y < z) {
                return false;
            }
            if (x == 0 || y == 0) {
                return z == 0 || x + y == z;
            }
            return z % gcd(x, y) == 0;
        }

        public int gcd(int x, int y) {
            int remainder = x % y;
            while (remainder != 0) {
                x = y;
                y = remainder;
                remainder = x % y;
            }
            return y;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


}