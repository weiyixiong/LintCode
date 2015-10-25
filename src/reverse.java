public class reverse {
	/**
	 * @param head
	 *            : The head of linked list.
	 * @return: The new head of reversed linked list.
	 */
	public ListNode reverse(ListNode head) {
		ListNode res = head;
		ListNode t1 = head;
		ListNode t2 = head;
		while (head != null && head.next != null) {
			t2 = head.next;
			head.next = head.next.next;
			t2.next = t1;
			t1 = t2;
		}
		if (head != null)
			head.next = null;
		return t2;

	}
}
