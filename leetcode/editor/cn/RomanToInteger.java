package leetcode.editor.cn;

//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + 
//II 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "III"
//输出: 3 
//
// 示例 2: 
//
// 
//输入: s = "IV"
//输出: 4 
//
// 示例 3: 
//
// 
//输入: s = "IX"
//输出: 9 
//
// 示例 4: 
//
// 
//输入: s = "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: s = "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 15 
// s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M') 
// 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内 
// 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。 
// IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。 
// 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。 
// 
// Related Topics 哈希表 数学 字符串 👍 1903 👎 0

public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    // class Solution {
    //     public int romanToInt(String s) {
    //         // 初始化变量
    //         int convert = 0;
    //         Map<String, Integer> dict = new HashMap<>();
    //         dict.put("I", 1);
    //         dict.put("V", 5);
    //         dict.put("X", 10);
    //         dict.put("L", 50);
    //         dict.put("C", 100);
    //         dict.put("D", 500);
    //         dict.put("M", 1000);
	// 		dict.put("IV",4);
	// 		dict.put("IX",9);
	// 		dict.put("XL",40);
	// 		dict.put("XC",90);
	// 		dict.put("CD",400);
	// 		dict.put("CM",900);
    //         // 
    //         for (int i = 0; i < s.length(); i++) {
    //             // 当前位置不是最后一位，且两位字符的罗马数字是否存在
    //             if (i!=s.length()-1&&dict.containsKey(s.substring(i,i+2))) {
    //                 // 存在，加入到结果中
    //                 convert += dict.get(s.substring(i,i+2));
    //                 // 跳过下一位罗马数字
    //                 ++i;
    //             } else {
    //                 // 不存在，获取当前位置的罗马数字的值
    //                 convert += dict.get(s.substring(i,i+1));
    //             }
    //         }
    //         return convert;
    //     }
    // }
    class Solution {
        public int romanToInt(String s) {
            s = s.replace("IV","a");
            s = s.replace("IX","b");
            s = s.replace("XL","c");
            s = s.replace("XC","d");
            s = s.replace("CD","e");
            s = s.replace("CM","f");
        
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                res += getValue(s.charAt(i));
            }
            return res;
        }
    
        public int getValue(char c) {
            switch(c) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                case 'a': return 4;
                case 'b': return 9;
                case 'c': return 40;
                case 'd': return 90;
                case 'e': return 400;
                case 'f': return 900;
            }
            return 0;
        }
    }
	//leetcode submit region end(Prohibit modification and deletion)
    
}