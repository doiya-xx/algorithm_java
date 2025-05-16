import algorithms.tree.BinaryTree;
import commons.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TreeTest {

    @Test
    public void treeTest() {
        TreeNode root = BinaryTree.constructTreeFromLevelOrder(new Integer[]{1, 2});
        List<Integer> integers = BinaryTree.levelOrder(root);
        System.out.println("integers = " + integers);
        List<Integer> integers1 = BinaryTree.deepOrder(root);
        System.out.println("integers1 = " + integers1);
    }
}
