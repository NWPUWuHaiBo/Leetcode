package sortByCategory.LinkedList;

/**
 * @author haiboWu
 * @create 2020-06-07 9:38
 */
public class No_21_MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode p1 = l1, p2 = l2;

        ListNode cur = new ListNode(-1);
        ListNode head = cur;
        while (p1 != null && p2 != null) {
            int val1 = p1 == null ? Integer.MIN_VALUE : p1.val;
            int val2 = p2 == null ? Integer.MIN_VALUE : p2.val;
            if (val1 < val2) {
                cur.next = p1;
                p1 = p1.next;

            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 == null) {
            cur.next = p2;
        } else {
            cur.next = p1;
        }
        return head.next;
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
