import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class MergeBinaryTreeTest {

    private MergeBinaryTree merge = new MergeBinaryTree();

    @Test
    void test() {
        TreeNode tree1 = generateTree("1,3,2,5");

        TreeNode tree2 = generateTree("2,1,3,null,4,null,7");

        TreeNode resultTree = merge.mergeTrees(tree1, tree2);

        TreeNode expectTree = generateTree("3,4,5,5,4,null,7");

        assertNotEquals(tree1, tree2);
    }

    @Test
    void only_root_node() {
        TreeNode tree1 = generateTree("1");
        TreeNode tree2 = generateTree("3");

        TreeNode expectTree = generateTree("4");

        assertEquals(expectTree, merge.mergeTrees(tree1, tree2));
    }

    @Test
    void full_node() {
        TreeNode tree1 = generateTree("1,2,3");
        TreeNode tree2 = generateTree("3,4,5");

        TreeNode expectTree = generateTree("4,6,8");

        assertEquals(expectTree, merge.mergeTrees(tree1, tree2));
    }

    @Test
    void only_left_node() {
        TreeNode tree1 = generateTree("1,2");
        TreeNode tree2 = generateTree("3,4");

        TreeNode expectTree = generateTree("4,6");

        assertEquals(expectTree, merge.mergeTrees(tree1, tree2));
    }

    @Test
    void only_right_node() {
        TreeNode tree1 = generateTree("1,null,2");
        TreeNode tree2 = generateTree("3,null,4");

        TreeNode expectTree = generateTree("4,null,6");

        assertEquals(expectTree, merge.mergeTrees(tree1, tree2));
    }

    @Test
    void left_right_may_null_node() {
        TreeNode tree1 = generateTree("1,null,2");
        TreeNode tree2 = generateTree("3,4,null");

        TreeNode expectTree = generateTree("4,4,2");

        assertEquals(expectTree, merge.mergeTrees(tree1, tree2));
    }

    @Test
    void should_equal_root_tree() {
        TreeNode tree1 = generateTree("1,3,2,5");
        TreeNode tree2 = generateTree("1,3,2,5");

        assertEquals(tree1, tree2);
    }

    @Test
    void should_equal_left_node_null_tree() {
        TreeNode tree1 = generateTree("1,null,2");
        TreeNode tree2 = generateTree("1,null,2");

        assertEquals(tree1, tree2);
    }

    @Test
    void should_equal_right_node_null_tree() {
        TreeNode tree1 = generateTree("1,2,null");
        TreeNode tree2 = generateTree("1,2,null");

        assertEquals(tree1, tree2);
    }

    @Test
    void should_not_equal_right_node_null_tree() {
        TreeNode tree1 = generateTree("1,null,2");
        TreeNode tree2 = generateTree("1,2,null");

        assertNotEquals(tree1, tree2);
    }

    @Test
    void should_not_equal_root_node_tree() {
        TreeNode tree1 = generateTree("1");
        TreeNode tree2 = generateTree("2");

        assertNotEquals(tree1, tree2);
    }

    static TreeNode generateTree(String treeString) {
        String[] parts = treeString.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        String item;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (index == parts.length) break;

            item = parts[index++];
            if (!item.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(item.trim()));
                queue.add(node.left);
            }

            if (index == parts.length) break;

            item = parts[index++];
            if (!item.equals("null")) {
                node.right = new TreeNode(Integer.parseInt(item.trim()));
                queue.add(node.right);
            }
        }

        return root;
    }

}