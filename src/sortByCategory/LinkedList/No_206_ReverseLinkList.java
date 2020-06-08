package sortByCategory.LinkedList;

/**
 * @author haiboWu
 * @create 2020-06-06 18:54
 */
public class No_206_ReverseLinkList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //1.保存当前节点的下一个节点
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
