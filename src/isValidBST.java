public class isValidBST {
	/**
	 * @param root
	 *            : The root of binary tree.
	 * @return: True if the binary tree is BST, or false
	 */
	private int lastVal = Integer.MIN_VALUE;
	private boolean firstNode = true;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isValidBST(root.left)) {
			return false;
		}
		if (!firstNode && lastVal >= root.val) {
			return false;
		}
		firstNode = false;
		lastVal = root.val;
		if (!isValidBST(root.right)) {
			return false;
		}
		return true;
	}

}
