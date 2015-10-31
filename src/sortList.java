public class sortList {
	/**
	 * @param head
	 *            : The head of linked list.
	 * @return: You should return the head of the sorted linked list, using
	 *          constant space complexity.
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode t1 = head;
		ListNode t2 = head.next;
		while (t2 != null && t2.next != null) {
			t2 = t2.next.next;
			t1 = t1.next;
		}
		ListNode mid = t1.next;
		t1.next = null;
		ListNode res = new ListNode(0);
		ListNode resHead = res;
		head = sortList(head);
		mid = sortList(mid);
		while (head != null && mid != null) {
			if (head.val > mid.val) {
				res.next = mid;
				mid = mid.next;
			} else {
				res.next = head;
				head = head.next;
			}
			res = res.next;
		}
		while (head != null) {
			res.next = head;
			head = head.next;
			res = res.next;
		}
		while (mid != null) {
			res.next = mid;
			mid = mid.next;
			res = res.next;
		}
		return resHead.next;
	}
}
