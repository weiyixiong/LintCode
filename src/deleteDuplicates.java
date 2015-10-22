public class deleteDuplicates {
	/**
	 * @param ListNode
	 *            head is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode res = head;
		while (head != null && head.next != null) {
			if (head.val == head.next.val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return res;
	}
}
