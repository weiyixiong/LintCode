public class isBalanced {
	/**
	 * @param root
	 *            : The root of binary tree.
	 * @return: True if this Binary tree is Balanced, or false.
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return Level(root) != -1;
	}

	public int Level(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int LLevel = Level(root.left) + 1;
		int RLevel = Level(root.right) + 1;
		if (LLevel == 0 || RLevel == 0) {
			return -1;
		}
		return Math.abs(LLevel - RLevel) < 2 ? Math.max(LLevel, RLevel) : -1;
	}
}
