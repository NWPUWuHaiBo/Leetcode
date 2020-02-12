package part3;

import java.util.Stack;

/**
 * @author haiboWu
 * @create 2020-02-10 23:33
 */
public class No_25 {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        if (head == null) return dummy.next;
        dummy.next = head;
        ListNode cur = dummy;
        ListNode next = dummy.next;

        Stack<ListNode> stack = new Stack<>();

        while (next!=null){

            for (int i = 0; i < k && next != null; i++) {
                stack.push(next);
                next=next.next;
            }
            if(stack.size()!=k)return dummy.next;
            for (int i = 0; i < k; i++) {
                cur.next=stack.pop();
                cur=cur.next;
            }
            cur.next=next;
        }
        return dummy.next;
    }

}
