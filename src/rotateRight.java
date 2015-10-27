public class rotateRight {
	/**
	 * @param head
	 *            : the List
	 * @param k
	 *            : rotate to the right k places
	 * @return: the list after rotation
	 */
	public ListNode rotateRight(ListNode head, int k) {
		ListNode t1 = head;
		ListNode t2 = head;
		if (head == null) {
			return null;
		}
		for (int i = 0; i < k; i++) {
			t2 = t2.next;
			if (t2 == null) {
				t2 = head;
			}
		}
		while (t2.next != null) {
			t2 = t2.next;
			t1 = t1.next;
		}
		t2.next = head;
		ListNode res = t1.next;
		t1.next = null;
		return res;
	}
}
