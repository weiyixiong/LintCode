public class sortedListToBST {
	/**
	 * @param head
	 *            : The first node of linked list.
	 * @return: a tree node
	 */
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode mid = head;
		ListNode end = head.next.next;
		while (end != null && end.next != null) {
			mid = mid.next;
			end = end.next.next;
		}
		TreeNode root = new TreeNode(mid.next.val);
		root.right = sortedListToBST(mid.next.next);
		mid.next = null;
		root.left = sortedListToBST(head);
		return root;
	}
}
