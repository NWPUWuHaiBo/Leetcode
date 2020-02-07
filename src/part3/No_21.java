package part3;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * @author haiboWu
 * @create 2020-02-06 20:59
 */
public class No_21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode head=root;

        while (l1!=null||l2!=null){
            int val1=l1==null?Integer.MAX_VALUE:l1.val;
            int val2=l1==null?Integer.MAX_VALUE:l1.val;
            if(val1>val2){
                ListNode newNode=new ListNode(val2);
                head.next=newNode;
                head=head.next;
                l2=l2.next;
            }else{
                ListNode newNode=new ListNode(val1);
                head.next=newNode;
                head=head.next;
                l1=l1.next;
            }
        }
        return root.next;
    }
}
