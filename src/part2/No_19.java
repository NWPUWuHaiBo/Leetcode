package part2;

/**
 * @author haiboWu
 * @create 2020-02-05 20:43
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class No_19 {
    public static void main(String[] args) {

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=new ListNode(0);
        temp.next=head;
        ListNode l1=temp;
        ListNode l2=temp;
        for (int i = 0; i <= n; i++) {
            l1 = l1.next;
        }

        while (l1 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        l2.next = l2.next.next;
        return temp.next;
    }

    public static void showList(ListNode head) {
        ListNode root = head;
        while (root.next != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
