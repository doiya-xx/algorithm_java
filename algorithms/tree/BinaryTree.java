package algorithms.tree;

import java.util.*;

import commons.TreeNode;
import utils.CollectionUtils;

public class BinaryTree {
    
    // 广度优先遍历
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
    
    // 广度优先遍历，每层都分开
    public static List<List<Integer>> leverOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }
    
    // 深度优先遍历
    public static List<Integer> deepOrder(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.add(node.val);
        res.addAll(deepOrder(node.left));
        res.addAll(deepOrder(node.right));
        return res;
    }
    
    // 前序遍历
    public static List<Integer> preorderTraversal(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.add(node.val);
        res.addAll(preorderTraversal(node.left));
        res.addAll(preorderTraversal(node.right));
        return res;
    }
    
    // 中序遍历
    public static List<Integer> inorderTraversal(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(inorderTraversal(node.left));
        res.add(node.val);
        res.addAll(inorderTraversal(node.right));
        return res;
    }
    
    // 后序遍历
    public static List<Integer> postorderTraversal(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(postorderTraversal(node.left));
        res.addAll(postorderTraversal(node.right));
        res.add(node.val);
        return res;
    }
    
    public static int getTreeDeepCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = 0, rightDeep = 0;
        if (root.left != null) {
            leftDeep = getTreeDeepCount(root.left);
        }
        if (root.right != null) {
            rightDeep = getTreeDeepCount(root.right);
        }
        return Math.max(leftDeep, rightDeep) + 1;
    }
    
    public static TreeNode constructTreeFromLevelOrder(Integer[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }
        int length = levelOrder.length;
        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        for (int i = 1; i < length; i += 2) {
            TreeNode parent = queue.poll();
            if (parent == null) {
                continue;
            }
            Integer leftVal = levelOrder[i];
            Integer rightVal = (i + 1 < length) ? levelOrder[i + 1] : null;
            if (leftVal != null) {
                parent.left = new TreeNode(leftVal);
                queue.offer(parent.left);
            }
            if (rightVal != null) {
                parent.right = new TreeNode(rightVal);
                queue.offer(parent.right);
            }
        }
        return root;
    }
    
    public static TreeNode constructTreeFromPreIn(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null;
        }
        int length = preorder.size();
        TreeNode root = new TreeNode(preorder.get(0));
        int index = inorder.indexOf(root.val);
        List<Integer> preorder_left = preorder.subList(1, index + 1);
        List<Integer> preorder_right = preorder.subList(index + 1, length);
        List<Integer> inorder_left = inorder.subList(0, index);
        List<Integer> inorder_right = inorder.subList(index + 1, length);
        root.left = constructTreeFromPreIn(preorder_left, inorder_left);
        root.right = constructTreeFromPreIn(preorder_right, inorder_right);
        return root;
    }
    
    public static TreeNode constructTreeFromPrePost(List<Integer> preorder, List<Integer> postorder) {
        int length = preorder.size();
        TreeNode root = new TreeNode(preorder.get(0));
        if (length == 1) {
            return root;
        }
        int index = postorder.indexOf(preorder.get(1));
        List<Integer> preorder_left = preorder.subList(1, index + 2);
        List<Integer> preorder_right = preorder.subList(index + 2, length);
        List<Integer> postorder_left = postorder.subList(0, index + 1);
        List<Integer> postorder_right = postorder.subList(index + 1, length - 1);
        root.left = constructTreeFromPrePost(preorder_left, postorder_left);
        root.right = constructTreeFromPrePost(preorder_right, postorder_right);
        return root;
    }
    
    public static TreeNode constructTreeFromInPost(List<Integer> inorder, List<Integer> postorder) {
        if (inorder.isEmpty() || postorder.isEmpty()) {
            return null;
        }
        int length = inorder.size();
        TreeNode root = new TreeNode(postorder.get(length - 1));
        int index = inorder.indexOf(root.val);
        List<Integer> inorder_left = inorder.subList(0, index);
        List<Integer> inorder_right = inorder.subList(index + 1, length);
        List<Integer> postorder_left = postorder.subList(0, index);
        List<Integer> postorder_right = postorder.subList(index, length - 1);
        root.left = constructTreeFromInPost(inorder_left, postorder_left);
        root.right = constructTreeFromInPost(inorder_right, postorder_right);
        return root;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    /**
     * 根据Integer[]数组创建二叉树
     *
     * @param array Integer[]数组
     * @return {@code TreeNode}
     */
    public static TreeNode createBinaryTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        for (Integer i : array) {
            if (i == null) {
                nodeList.add(null);
            } else {
                nodeList.add(new TreeNode(i));
            }
        }
        TreeNode root = nodeList.get(0);
        for (int i = 0; i < array.length / 2; i++) {
            TreeNode node = nodeList.get(i);
            if (node == null) {
                continue;
            }
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;
            if (leftIndex < nodeList.size()) {
                node.left = nodeList.get(leftIndex);
            }
            if (rightIndex < nodeList.size()) {
                node.right = nodeList.get(rightIndex);
            }
        }
        return root;
    }

    /**
     * 基于广度优先，根据Integer[]数组创建二叉树
     *
     * @param array Integer[]数组
     * @return {@code TreeNode}
     */
    public static TreeNode createBinaryTreeByBreadthFirst(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            TreeNode node = queue.poll();
            if (array[i] != null) {
                node.left = new TreeNode(array[i]);
                queue.offer(node.left);
            }
            i++;
            if (i < array.length && array[i] != null) {
                node.right = new TreeNode(array[i]);
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    /**
     * 根据前序遍历List<Integer>和中序遍历List<Integer>创建二叉树
     *
     * @param preorder 前序遍历List<Integer>
     * @param inorder  中序遍历List<Integer>
     * @return {@code TreeNode}
     */
    public static TreeNode createBinaryTreeByPreIn(List<Integer> preorder, List<Integer> inorder) {
        if (CollectionUtils.isEmpty(preorder, inorder)) {
            return null;
        }
        int length = preorder.size();
        if (length == 1) {
            return new TreeNode(preorder.get(0));
        }
        TreeNode root = new TreeNode(preorder.get(0));
        int rootIndex = inorder.indexOf(preorder.get(0));
        root.left = createBinaryTreeByPreIn(
                preorder.subList(1, rootIndex + 1),
                inorder.subList(0, rootIndex)
        );
        root.right = createBinaryTreeByPreIn(
                preorder.subList(rootIndex + 1, length),
                inorder.subList(rootIndex + 1, length)
        );
        return root;
    }

    /**
     * <p>根据前序遍历{@code int[]}和中序遍历{@code int[]}创建二叉树</p>
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode createBinaryTreeByPreIn(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = 0;
        for (int i = 0; i < length; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndex = i;
                break;
            }
        }
        root.left = createBinaryTreeByPreIn(
                Arrays.copyOfRange(preorder, 1, rootIndex + 1),
                Arrays.copyOfRange(inorder, 0, rootIndex)
        );
        root.right = createBinaryTreeByPreIn(
                Arrays.copyOfRange(preorder, rootIndex + 1, length),
                Arrays.copyOfRange(inorder, rootIndex + 1, length)
        );
        return root;
    }

    /**
     * <p>基于栈，根据前序遍历List<Integer>和中序遍历List<Integer>创建二叉树</p>
     * <p>速度最优</p>
     * <p>形参不需要修改长度，不需要有元素为null，所以使用int[]更快更省空间</p>
     *
     * @param preorder 前序遍历 {@code int[]}
     * @param inorder 中序遍历 {@code int[]}
     * @return {@code TreeNode}
     */
    public static TreeNode createBinaryTreeByPreInByStack(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * <p>基于递归，根据中序遍历List<Integer>和后序遍历List<Integer>创建二叉树</p>
     * <p>速度远远不如基于栈</p>
     *
     * @param inorder   中序遍历List<Integer>
     * @param postorder 后序遍历List<Integer>
     * @return {@code TreeNode}
     */
    public static TreeNode createBinaryTreeByInPost(List<Integer> inorder, List<Integer> postorder) {
        if (CollectionUtils.isEmpty(inorder, postorder)) {
            return null;
        }
        int length = postorder.size();
        if (length == 1) {
            return new TreeNode(postorder.get(0));
        }
        TreeNode root = new TreeNode(postorder.get(length - 1));
        int rootIndex = inorder.indexOf(postorder.get(length - 1));
        root.left = createBinaryTreeByInPost(
                inorder.subList(0, rootIndex),
                postorder.subList(0, rootIndex)
        );
        root.right = createBinaryTreeByInPost(
                inorder.subList(rootIndex + 1, length),
                postorder.subList(rootIndex, length - 1)
        );
        return root;
    }

    /**
     * <p>基于栈，根据中序遍历List<Integer>和后序遍历List<Integer>创建二叉树</p>
     * <p>速度最优</p>
     * <p>形参不需要修改长度，不需要有元素为null，所以使用int[]更快更省空间</p>
     *
     * @param inorder   中序遍历 {@code int[]}
     * @param postorder 后序遍历 {@code int[]}
     * @return {@code TreeNode}
     */
    public static TreeNode createBinaryTreeByInPostByStack(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        int length = postorder.length;
        TreeNode root = new TreeNode(postorder[length - 1]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = length - 1;
        for (int i = length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }

    /**
     * 根据前序遍历List<Integer>和后序遍历List<Integer>创建二叉树
     *
     * @param preorder  前序遍历List<Integer>
     * @param postorder 后序遍历List<Integer>
     * @return {@code TreeNode}
     */
    public static TreeNode createBinaryTreeByPrePost(List<Integer> preorder, List<Integer> postorder) {
        if (CollectionUtils.isEmpty(preorder, postorder)) {
            return null;
        }
        int length = preorder.size();
        if (length == 1) {
            return new TreeNode(preorder.get(0));
        }
        TreeNode root = new TreeNode(preorder.get(0));
        int rootIndex = preorder.indexOf(postorder.get(length - 2));
        List<Integer> leftPreorder = preorder.subList(1, rootIndex);
        List<Integer> rightPreorder = preorder.subList(rootIndex, length);
        List<Integer> leftPostorder = postorder.subList(0, rootIndex - 1);
        List<Integer> rightPostorder = postorder.subList(rootIndex - 1, length - 1);
        root.left = createBinaryTreeByPrePost(leftPreorder, leftPostorder);
        root.right = createBinaryTreeByPrePost(rightPreorder, rightPostorder);
        return root;
    }


    /**
     * 二叉树的广度优先遍历 打印输出
     */
    public static void printBreadthFirstTraversal(TreeNode root) {
        System.out.println(getBreadthFirstTraversal(root));
    }

    /**
     * 二叉树的深度优先遍历
     */
    public static void printDepthFirstTraversal(TreeNode root) {
        System.out.println(getDepthFirstTraversal(root));
    }

    /**
     * 二叉树的前序遍历
     */
    public static void printPreorderTraversal(TreeNode root) {
        System.out.println(getPreorderTraversalByRecursion(root));
    }

    /**
     * 二叉树的中序遍历
     */
    public static void printInorderTraversal(TreeNode root) {
        System.out.println(getInorderTraversalByRecursion(root));
    }

    /**
     * 二叉树的后序遍历
     */
    public static void printPostorderTraversal(TreeNode root) {
        System.out.println(getPostorderTraversalByRecursion(root));
    }

    /**
     * 二叉树的广度优先遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<Integer>}
     */
    public static List<Integer> getBreadthFirstTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点入队
        queue.offer(root);
        List<Integer> list = new ArrayList<>(); // 用于存放遍历结果
        while (!queue.isEmpty()) {
            // 出队
            TreeNode node = queue.poll();
            list.add(node.val);
            // 如果左子节点不为空，则入队
            if (node.left != null) {
                queue.offer(node.left);
            }
            // 如果右子节点不为空，则入队
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list;
    }

    /**
     * 二叉树的层序遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<List<Integer>>}
     */
    public static List<List<Integer>> getLevelTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点入队
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>(); // 用于存放遍历结果
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // 出队
                TreeNode node = queue.poll();
                subList.add(node.val);
                // 如果左子节点不为空，则入队
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 如果右子节点不为空，则入队
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(subList);
        }
        return list;
    }

    public static List<List<Integer>> getLevelTraversalFromDownToUp(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(0, subList);
        }
        return list;
    }

    /**
     * 二叉树的锯齿形层序遍历
     */
    public static List<List<Integer>> getZigzagLevelTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(node.val);
                } else {
                    levelList.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(new ArrayList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return list;
    }

    /**
     * 二叉树的深度优先遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<Integer>}
     */
    public static List<Integer> getDepthFirstTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.left != null) {
            list.addAll(getDepthFirstTraversal(root.left));
        }
        if (root.right != null) {
            list.addAll(getDepthFirstTraversal(root.right));
        }
        return list;
    }

    /**
     * 二叉树的深度优先遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<List<Integer>>}
     */
    public static List<List<Integer>> getDepthFirstTraversalByLevel(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        subList.add(root.val);
        list.add(subList);
        if (root.left != null) {
            list.addAll(getDepthFirstTraversalByLevel(root.left));
        }
        if (root.right != null) {
            list.addAll(getDepthFirstTraversalByLevel(root.right));
        }
        return list;
    }

    /**
     * 基于递归，二叉树的前序遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<Integer>}
     */
    public static List<Integer> getPreorderTraversalByRecursion(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        list.addAll(getPreorderTraversalByRecursion(root.left));
        list.addAll(getPreorderTraversalByRecursion(root.right));
        return list;
    }

    /**
     * 基于栈的迭代，二叉树的前序遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<Integer>}
     */
    public static List<Integer> getPreorderTraversalByStack(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    /**
     * 基于Mirrors，二叉树的前序遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<Integer>}
     */
    public static List<Integer> getPreorderTraversalByMirrors(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return list;
    }

    /**
     * 基于递归，二叉树的中序遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<Integer>}
     */
    public static List<Integer> getInorderTraversalByRecursion(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(getInorderTraversalByRecursion(root.left));
        list.add(root.val);
        list.addAll(getInorderTraversalByRecursion(root.right));
        return list;
    }

    /**
     * 基于栈的迭代，二叉树的中序遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<Integer>}
     */
    public static List<Integer> getInorderTraversalByStack(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    /**
     * 基于Mirrors，二叉树的中序遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<Integer>}
     */
    public static List<Integer> getInorderTraversalByMirrors(TreeNode root) {
        // 检查根节点是否为空，如果为空，则返回一个空的 ArrayList
        if (root == null) {
            return new ArrayList<>();
        }

        // 初始化一个空的 ArrayList 用于存储遍历的结果
        List<Integer> list = new ArrayList<>();

        // 初始化两个 TreeNode 变量，cur 和 pre。cur 初始设置为树的根节点
        TreeNode cur = root;
        TreeNode pre;

        // 进入一个 while 循环，只要 cur 不为空就继续
        while (cur != null) {
            // 检查 cur 的左子节点是否为空
            if (cur.left == null) {
                // 如果为空，将 cur 的值添加到 list 中，并将 cur 移动到其右子节点
                list.add(cur.val);
                cur = cur.right;
            } else {
                // 如果 cur 的左子节点不为空，将 pre 设置为 cur 的左子节点，并进入另一个 while 循环
                pre = cur.left;
                while (pre.right != null) {
                    // 只要 pre 的右子节点不为空，就将 pre 移动到其右子节点
                    pre = pre.right;
                }
                // 在内部 while 循环之后，将 pre 的右子节点设置为 cur，将 cur 移动到其左子节点，并将原始 cur 的左子节点设置为 null
                pre.right = cur;
                TreeNode temp = cur;
                cur = cur.left;
                temp.left = null;
            }
        }
        // 在外部 while 循环之后，返回 list，它现在包含了二叉树的中序遍历
        return list;
    }

    /**
     * 基于栈，二叉树的中序遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<TreeNode>}
     */
    public static List<TreeNode> getInorderTraversalByStack2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node);
                node = node.right;
            }
        }
        return list;
    }

    /**
     * 基于递归，二叉树的后序遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<Integer>}
     */
    public static List<Integer> getPostorderTraversalByRecursion(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(getPostorderTraversalByRecursion(root.left));
        list.addAll(getPostorderTraversalByRecursion(root.right));
        list.add(root.val);
        return list;
    }

    /**
     * 基于栈的迭代，二叉树的后序遍历
     *
     * @param root 二叉树的根节点
     * @return {@code List<Integer>}
     */
    public static List<Integer> getPostorderTraversalByStack(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(0, node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return list;
    }

    /**
     * 计算二叉树的深度
     */
    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 计算二叉树的节点数
     */
    public static int getNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getNodeCount(root.left) + getNodeCount(root.right) + 1;
    }

    /**
     * 交换两个节点的值
     */
    public static void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    /**
     * 判断二叉树是否对称
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 判断二叉树是否平衡
     */
    public static boolean isBalanced(TreeNode root) {
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
    }
}
