package sortByOrder.part3;

/**
 * @author haiboWu
 * @create 2020-02-10 19:09
 */
public class No_24 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        if (head == null) return dummy.next;
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            swap(cur);
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public void swap(ListNode preNode) {
        ListNode next = preNode.next.next;
        preNode.next.next = next.next;
        next.next = preNode.next;
        preNode.next = next;
    }
}
