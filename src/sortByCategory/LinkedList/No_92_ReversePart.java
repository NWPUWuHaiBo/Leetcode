package sortByCategory.LinkedList;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-11-12 11:14
 */
public class No_92_ReversePart {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode root2 = head;
        int n = 1;
        while (n <= 5) {
            n++;
            ListNode next = new ListNode(n);
            head.next = next;
            head = next;
        }

        ListNode newRoot = reverseBetween(root2, 2,4);
        System.out.println("");
        while (newRoot.next != null) {
            System.out.print(newRoot.val + ",");
            newRoot = newRoot.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return  reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode successor = null;

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }
}
