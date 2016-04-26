/**
 * Created by winney on 16/4/26.
 */
public class isPalindrome {

    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode halfHeader = head;
        ListNode tmp2 = head;
        while (tmp2 != null && tmp2.next != null) {
            halfHeader = halfHeader.next;
            tmp2 = tmp2.next.next;
        }
        ListNode reverseHeader = halfHeader;
        ListNode t1 = reverseHeader;
        ListNode t2 =t1.next;
        while (t1.next!=null) {
            t2 = t1.next;
            t1.next = t2.next;
            t2.next = reverseHeader;
            reverseHeader = t2;
        }
        while (head != reverseHeader&&reverseHeader!=null) {
            if (head.val != reverseHeader.val) {
                return false;
            }
            head=head.next;
            reverseHeader=reverseHeader.next;
        }
        return true;

    }

}
