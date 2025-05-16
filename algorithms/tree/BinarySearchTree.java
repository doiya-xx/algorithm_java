package algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import commons.*;

public class BinarySearchTree extends BinaryTree{

    /**
     * 生成全部二叉搜索树
     */
    // public List<TreeNode> generateTrees(int n) {
    //     if (n == 0) {
    //         return new LinkedList<TreeNode>();
    //     }
    //     return generateTrees(1, n);
    // }
    //
    // public List<TreeNode> generateTrees(int start, int end) {
    //     List<TreeNode> allTrees = new LinkedList<>();
    //     if (start > end) {
    //         allTrees.add(null);
    //         return allTrees;
    //     }
    //
    //     // 枚举可行根节点
    //     for (int i = start; i <= end; i++) {
    //         // 获得所有可行的左子树集合
    //         List<TreeNode> leftTrees = generateTrees(start, i - 1);
    //
    //         // 获得所有可行的右子树集合
    //         List<TreeNode> rightTrees = generateTrees(i + 1, end);
    //
    //         // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
    //         for (TreeNode left : leftTrees) {
    //             for (TreeNode right : rightTrees) {
    //                 TreeNode currTree = new TreeNode(i);
    //                 currTree.left = left;
    //                 currTree.right = right;
    //                 allTrees.add(currTree);
    //             }
    //         }
    //     }
    //     return allTrees;
    // }

    /**
     * 验证是否为二叉搜索树
     * 1. 递归
     * 时间复杂度：O(n)
     * 空间复杂的：O(n)
     * 2. 中序遍历
     * 时间复杂度：O(n)
     * 空间复杂的：O(n)
     */
    // public boolean isValidBST(TreeNode root) {
    //     return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    // }

    public boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        boolean leftIsValidBST = isValidBST(root.left, min, root.val);
        boolean rightIsValidBST = isValidBST(root.right, root.val, max);
        return leftIsValidBST && rightIsValidBST;
    }

    /**
     * <p>将有序数组转换为二叉搜索树</p>
     *
     * @param nums 有序数组
     * @return 二叉搜索树
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    /**
     * <p>将有序链表转换为二叉搜索树</p>
     *
     * @param head 有序链表
     * @return 二叉搜索树
     */
    public static TreeNode sortedListToBST(ListNode head) {
        // 如果链表为空，返回null
        if (head == null) {
            return null;
        }

        // 如果链表只有一个节点，返回这个节点作为树的根节点
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // 使用快慢指针找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 断开链表在中间节点处，将链表分为两部分
        prev.next = null;

        // 创建根节点
        TreeNode root = new TreeNode(slow.val);

        // 递归地将链表的左半部分和右半部分转换为左子树和右子树
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }

    /**
     * 计算二叉搜索树的种数
     */
    public static int numTrees(int n) {
        // 如果节点数量为0或1，那么只能构成一种BST，所以返回1
        if (n == 0 || n == 1) {
            return 1;
        }

        // 初始化动态规划数组，长度为节点数量n+1
        int[] dp = new int[n + 1];

        // 当节点数量为0时，只有一种BST
        dp[0] = 1;

        // 对于每一个数量i（从1到n）
        for (int i = 1; i <= n; i++) {
            // 对于每一个数量j（从0到i）
            for (int j = 0; j < i; j++) {
                // dp[i]等于dp[j]和dp[i-j-1]的乘积的和
                // dp[j]表示左子树的可能BST数量
                // dp[i-j-1]表示右子树的可能BST数量
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        // 返回节点数量为n时的可能BST数量
        return dp[n];
    }

    /**
     * 生成所有由n个节点组成且节点值从1到n互不相同的不同二叉搜索树
     */
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTrees(start, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }

    static long pre = Long.MIN_VALUE;

    /**
     * 判断二叉树是否为有效二叉搜索树
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

    /**
     * 基于Mirrors，将一颗普通二叉树恢复为二叉搜索树，且不改变原来的树结构（只有两个节点有问题）
     */
    public static void recoverBSTTree(TreeNode root) {
        // 获取中序遍历的结果
        List<TreeNode> inorder = getInorderTraversalByStack2(root);
        // 使用stream，获取List中需要交换的两个节点
        TreeNode x = null, y = null;
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i).val > inorder.get(i + 1).val) {
                y = inorder.get(i + 1);
                if (x == null) {
                    x = inorder.get(i);
                } else {
                    break;
                }
            }
        }
        // 交换两个节点的值
        swap(x, y);
    }

    /**
     * 判断两颗二叉树是否相同，即结构相同且节点值相同
     */
    // public static boolean isSameTree(TreeNode p, TreeNode q) {
    //     if (p == null && q == null) {
    //         return true;
    //     }
    //     if (p == null || q == null || p.val != q.val) {
    //         return false;
    //     }
    //     return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    // }
}
