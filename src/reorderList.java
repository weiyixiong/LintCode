public class reorderList {
	/**
	 * @param head
	 *            : The head of linked list.
	 * @return: void
	 */
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		ListNode t1 = head;
		ListNode t2 = head;
		while (t2 != null && t2.next != null) {
			t1 = t1.next;
			t2 = t2.next.next;
		}
		ListNode mid = t1;
		t2 = t1;
		ListNode midHead = t1;
		while (midHead != null && midHead.next != null) {
			t2 = midHead.next;
			midHead.next = t2.next;
			t2.next = mid;
			mid = t2;
		}
		midHead.next = null;
		ListNode resHead = head;
		ListNode tmp = head.next;
		ListNode tmp2 = mid.next;
		while (head != null && mid != null) {
			tmp = head.next;
			tmp2 = mid.next;
			head.next = mid;
			mid.next = tmp;
			head = tmp;
			mid = tmp2;
		}
		if (head != null) {
			head.next = null;
		}
		head = resHead;
	}

}
