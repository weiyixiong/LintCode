public class insertNode {
	/**
	 * @param root
	 *            : The root of the binary search tree.
	 * @param node
	 *            : insert this node into the binary search tree
	 */
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		if (root == null) {
			return node;
		}
		TreeNode res = root;
		TreeNode prev = null;
		while (root != null) {
			prev = root;
			if (node.val > root.val) {
				root = root.right;
			} else if (node.val < root.val) {
				root = root.left;
			} else {
				break;
			}
		}
		if (node.val > prev.val) {
			TreeNode tmp = prev.right;
			prev.right = node;
			node.right = tmp;
		} else {
			TreeNode tmp = prev.left;
			prev.left = node;
			node.left = tmp;
		}
		return res;
	}
}
