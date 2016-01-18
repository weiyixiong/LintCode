import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * Created by winney on 16/1/13.
 */
public class mergeKLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }
        ListNode res = null;
        List<ListNode> cache = new ArrayList<>();
        int size = lists.size() / 2 * 2;
        for (int i = 0; i < size - 1; ) {
            cache.add(merget2list(lists.get(i++), lists.get(i++)));
        }
        res = mergeKLists(cache);
        if (lists.size() > size) {
            res = merget2list(lists.get(size), res);
        }
        return res;
    }

    public ListNode merget2list(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        while (l1 != null) {
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }
        while (l2 != null) {
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        return res.next;
    }
}
