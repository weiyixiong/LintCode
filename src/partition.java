public class partition {
	/**
	 * @param head
	 *            : The first node of linked list.
	 * @param x
	 *            : an integer
	 * @return: a ListNode
	 */
	public ListNode partition(ListNode head, int x) {
		ListNode res = new ListNode(0);
		ListNode little = res;
		ListNode bigger = new ListNode(0);
		ListNode biggerHead = bigger;
		while (head != null) {
			if (head.val < x) {
				little.next = head;
				little = little.next;
			} else {
				bigger.next = head;
				bigger = bigger.next;
			}
			head = head.next;
		}
		bigger.next = null;
		little.next = biggerHead.next;
		return res.next;

	}

}
