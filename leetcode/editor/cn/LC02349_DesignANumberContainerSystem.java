// 题目编号：2349
// 题目标题：设计数字容器系统
// 题目标记：design-a-number-container-system

//<p>设计一个数字容器系统，可以实现以下功能：</p>
//
//<ul> 
// <li>在系统中给定下标处&nbsp;<strong>插入</strong>&nbsp;或者 <strong>替换</strong>&nbsp;一个数字。</li> 
// <li><strong>返回</strong>&nbsp;系统中给定数字的最小下标。</li> 
//</ul>
//
//<p>请你实现一个&nbsp;<code>NumberContainers</code>&nbsp;类：</p>
//
//<ul> 
// <li><code>NumberContainers()</code>&nbsp;初始化数字容器系统。</li> 
// <li><code>void change(int index, int number)</code> 在下标&nbsp;<code>index</code>&nbsp;处填入&nbsp;<code>number</code>&nbsp;。如果该下标&nbsp;<code>index</code>&nbsp;处已经有数字了，那么用 <code>number</code>&nbsp;替换该数字。</li> 
// <li><code>int find(int number)</code>&nbsp;返回给定数字&nbsp;<code>number</code>&nbsp;在系统中的最小下标。如果系统中没有&nbsp;<code>number</code>&nbsp;，那么返回&nbsp;<code>-1</code>&nbsp;。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例：</strong></p>
//
//<pre>
//<strong>输入：</strong>
//["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
//[[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
//<strong>输出：</strong>
//[null, -1, null, null, null, null, 1, null, 2]
//
//<strong>解释：</strong>
//NumberContainers nc = new NumberContainers();
//nc.find(10); // 没有数字 10 ，所以返回 -1 。
//nc.change(2, 10); // 容器中下标为 2 处填入数字 10 。
//nc.change(1, 10); // 容器中下标为 1 处填入数字 10 。
//nc.change(3, 10); // 容器中下标为 3 处填入数字 10 。
//nc.change(5, 10); // 容器中下标为 5 处填入数字 10 。
//nc.find(10); // 数字 10 所在的下标为 1 ，2 ，3 和 5 。因为最小下标为 1 ，所以返回 1 。
//nc.change(1, 20); // 容器中下标为 1 处填入数字 20 。注意，下标 1 处之前为 10 ，现在被替换为 20 。
//nc.find(10); // 数字 10 所在下标为 2 ，3 和 5 。最小下标为 2 ，所以返回 2 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= index, number &lt;= 10<sup>9</sup></code></li> 
// <li>调用&nbsp;<code>change</code> 和&nbsp;<code>find</code>&nbsp;的&nbsp;<strong>总次数</strong>&nbsp;不超过&nbsp;<code>10<sup>5</sup></code> 次。</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>设计 | 哈希表 | 有序集合 | 堆（优先队列）</details><br>
//
//<div>👍 31, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
//
//
//
//

package leetcode.editor.cn;

public class LC02349_DesignANumberContainerSystem {
    public static void main(String[] args) {
        NumberContainers solution = new LC02349_DesignANumberContainerSystem().new NumberContainers();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class NumberContainers {

    public NumberContainers() {

    }
    
    public void change(int index, int number) {

    }
    
    public int find(int number) {
        return 0;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
//leetcode submit region end(Prohibit modification and deletion)

}