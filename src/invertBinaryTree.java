import java.util.Stack;

/**
 * Created by winney on 16/4/14.
 */
public class invertBinaryTree {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }

    //非递归
    public void invertBinaryTree2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> cache = new Stack<>();
        cache.push(root);
        while (cache.isEmpty()) {
            TreeNode tmp = cache.pop();
            if (tmp == null) {
                continue;
            }
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            cache.push(tmp.left);
            cache.push(tmp.right);
        }
    }
}
