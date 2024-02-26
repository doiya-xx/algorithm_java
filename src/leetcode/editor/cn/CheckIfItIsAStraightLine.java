// 标题：缀点成线
// 标记：check-if-it-is-a-straight-line
// 编号：1232
// 时间：2024-02-14 15:40:40

//给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ，
// [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来判断，这些点是否在该坐标系中属于同一条直线上。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 
//输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 2 <= coordinates.length <= 1000 
// coordinates[i].length == 2 
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4 
// coordinates 中不含重复的点 
// 
//
// Related Topics 几何 数组 数学 👍 144 👎 0


package leetcode.editor.cn;

public class CheckIfItIsAStraightLine {
    
    public static void main(String[] args) {
        Solution solution = new CheckIfItIsAStraightLine().new Solution();
        System.out.println(solution.checkStraightLine(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
        System.out.println(solution.checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}