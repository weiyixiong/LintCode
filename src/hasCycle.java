public class hasCycle {
	/**
	 * @param head
	 *            : The first node of linked list.
	 * @return: True if it has a cycle, or false
	 */
	public boolean hasCycle(ListNode head) {
		ListNode t1 = head;
		while (head != null && head.next != null) {
			head = head.next.next;
			t1 = t1.next;
			if (head == t1) {
				return true;
			}
		}
		return false;
	}
}
