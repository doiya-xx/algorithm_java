package leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 2281 👎 0

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortStr(String[] strs) {
			int index = 0,length=strs[0].length();
			for (int i = 1;i<strs.length;i++){
                if (strs[i].length()<length) {
                    index = i;
                }
			}
            return strs[index];
        }
        
        public String longestCommonPrefix(String[] strs) {
            //公共前缀构造器
            StringBuilder sb = new StringBuilder();
            //找到当前长度最短的字符串
            char[] shortest_str = shortStr(strs).toCharArray();
            //从第一个字符开始判断是否为公前缀
            //最短字符串的当前字符
            for (int i=0;i<shortest_str.length;i++){
                //和每一个字符串的当前字符进行比较
                //如果有不相等的，则返回公共前缀
                for (int j = 0; j < strs.length; j++) {
                    if (strs[0].charAt(i)!=shortest_str[i]) {
                        return sb.toString();
                    }
                }
                //如果每一个字符串的当前字符都相等，则添加当前字符到构造器中
                sb.append(shortest_str[i]);
            }
            //如果最短字符都循环完，都添加到构造器中，则返回公共前缀
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
    
}