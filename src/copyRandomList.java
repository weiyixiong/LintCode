public class copyRandomList {
	/**
	 * @param head
	 *            : The head of linked list with a random pointer.
	 * @return: A new head of a deep copy of the list.
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode resHead = new RandomListNode(0);
		RandomListNode res = resHead;
		while (head != null) {
			resHead.next = new RandomListNode(head.label);
			if (head.random != null) {
				resHead.next.random = new RandomListNode(head.random.label);
			}
			resHead = resHead.next;
			head = head.next;
		}
		return res.next;
	}

}
