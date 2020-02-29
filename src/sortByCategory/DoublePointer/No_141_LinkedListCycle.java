package sortByCategory.DoublePointer;

/**
 * @author haiboWu
 * @create 2020-02-28 17:45
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

}

public class No_141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode l1 = head;
        ListNode l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null) {
            if(l1==l2){
                return true;
            }
            l1=l1.next;
            l2=l2.next.next;
        }
        return false;
    }

}
