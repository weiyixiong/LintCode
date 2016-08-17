/**
 * Created by winney on 16/8/17.
 */
public class swapNodes {
    /**
     * @param head a ListNode
     * @param v2   an integer
     * @return a new head of singly-linked list
     * @oaram v1 an integer
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode tmpHead = head;
        ListNode before = null;
        ListNode headcopy = head;
        ListNode firstNodeBefore = null;
        boolean firstFound = false;
        while (tmpHead != null) {
            if (tmpHead.val == v1 || tmpHead.val == v2) {
                if (firstNodeBefore == null && !firstFound) {
                    firstNodeBefore = before;
                    firstFound = true;
                } else {
                    ListNode secondBefore = before;
                    ListNode firstNode = firstNodeBefore == null ? headcopy : firstNodeBefore.next;
                    ListNode secondNode = before.next;
                    // System.out.print(firstNode.val+ ""+secondNode.val);
                    if (firstNodeBefore != null) {
                        firstNodeBefore.next = secondNode;
                    }
                    secondBefore.next = firstNode;
                    ListNode tmp = firstNode.next;
                    firstNode.next = secondNode.next;
                    secondNode.next = tmp;
                    if (firstNodeBefore == null) {
                        return secondNode;
                    }
                    break;
                }
            }
            before = tmpHead;
            tmpHead = tmpHead.next;
        }
        return head;
    }

}
