package sortByCategory.LinkedList;

/**
 * @author haiboWu
 * @create 2020-06-07 10:27
 */
public class No_24_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;
            pre = l1;
        }
        return node.next;
    }
}
