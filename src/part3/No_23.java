package part3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author haiboWu
 * @create 2020-02-09 19:05
 */


public class No_23 {
    public static void main(String[] args) {

    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);

        if (lists.length == 0) return dummy;
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode cur = dummy;
        Comparator<ListNode> cmp = new Comparator<ListNode>() {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };

        PriorityQueue<ListNode> pq = new PriorityQueue<>(cmp);
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null)
            pq.add(lists[i]);
        }
        while (pq.size() > 0) {
            ListNode node = pq.poll();
            cur.next = node;
            cur=cur.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;

    }

}
