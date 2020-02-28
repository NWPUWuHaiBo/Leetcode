package sortByOrder.part1;

import org.junit.Test;

class ListNode{
    int val;
    ListNode next;
    ListNode(int value){
        val=value;
    }
}
/**
 * @author haiboWu
 * @create 2020-02-24 15:40
 */
public class No_02 {
    @Test
    public void TestAdd(){

        ListNode l1=new ListNode(1);
        ListNode h1=l1;
        for (int i = 0; i < 3; i++) {
            ListNode node = new ListNode(i);
            l1.next=node;
            l1=l1.next;
        }
        ListNode l2=new ListNode(1);
        ListNode h2=l2;
        for (int i = 3; i < 6; i++) {
            ListNode node = new ListNode(i);
            l2.next=node;
            l2=l2.next;
        }
        addTwoNumbers(h1,h2);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode head=dummy;
        int add=0;
        while(l1!=null||l2!=null||add!=0){

            int var1=(l1==null)?0:l1.val;
            int var2=(l2==null)?0:l2.val;
            int sum=var1+var2+add;
            add=sum/10;
            head.next=new ListNode(sum%10);
            head=head.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;

        }
        return dummy.next;

    }
}
