package sortByCategory.LinkedList;

/**
 * @author haiboWu
 * @create 2020-06-07 10:10
 */
public class No_83_DeleteDuplicatesFromList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        ListNode pre=head;
        ListNode cur=head.next;
        while (cur!=null){
            ListNode temp=cur.next;
            if(cur.val==pre.val){
                pre.next=temp;
                cur=temp;
            }else {
                pre=cur;
                cur=temp;
            }
        }
        return head;
    }
}
