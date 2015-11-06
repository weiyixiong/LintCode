import java.util.ArrayList;
import java.util.Stack;

public class preorderTraversal {

	/**
	 * @param root
	 *            : The root of binary tree.
	 * @return: Preorder in ArrayList which contains node values.
	 */
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> cache = new Stack<TreeNode>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		cache.push(root);
		while (cache.size() > 0) {
			TreeNode tmpRoot = cache.pop();
			while (tmpRoot != null) {
				res.add(tmpRoot.val);
				if (tmpRoot.right != null) {
					cache.push(tmpRoot);
				}
				tmpRoot = tmpRoot.left;
			}
			if (cache.size() > 0) {
				cache.push(cache.pop().right);
			}
		}
		return res;
	}
}
