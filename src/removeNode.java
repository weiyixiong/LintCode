/**
 * Created by winney on 15/11/20.
 */
public class removeNode {
    /**
     * @param root:  The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        TreeNode myRoot = new TreeNode(0);
        myRoot.right = root;
        TreeNode result = myRoot;
        TreeNode parent = myRoot;
        while (root != null) {
            if (value < root.val) {
                parent = root;
                root = root.left;
            } else if (value > root.val) {
                parent = root;
                root = root.right;
            } else {
                //found it
                if (root.left == null && root.right == null) {
                    if (root == root) {
                        return null;
                    }
                    root = null;
                } else {
                    TreeNode rootLeft = root.left;
                    TreeNode rootRight = root.right;
                    if (root.right != null) {
                        TreeNode rightPar = root.right;
                        root = root.right;
                        while (root.left != null) {
                            rightPar = root;
                            root = root.left;
                        }
                        TreeNode tmp = root.right;
                        if (rightPar.left != null) {
                            root.left = rootLeft;
                            root.right = rootRight;
                        }
                        if (rightPar != root) {
                            rightPar.left = tmp;
                        }
                        if (parent.val > root.val) {
                            parent.left = root;
                        } else {
                            parent.right = root;
                        }
                    } else {
                        root = root.left;
                        if (parent.val > root.val) {
                            parent.left = root;
                        } else {
                            parent.right = root;
                        }
                    }
                    return result.right;
                }

            }

        }
        return result.right;


    }
}
