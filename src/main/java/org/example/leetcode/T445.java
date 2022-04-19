package org.example.leetcode;

public class T445 {
    public ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(0,null);
        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = next;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);
        ListNode dummy = new ListNode(1,null);

        int carry = 0;
        while(rl1!=null && rl2!=null){
            int a = rl1==null ? 0 : rl1.val;
            int b = rl2==null ? 0 : rl2.val;
            int sum = (a+b+carry)%10;
            carry = (a+b+carry)/10;
            ListNode current = new ListNode(sum);

            current.next = dummy.next;
            dummy.next = current;

            rl1 = rl1==null ? null : rl1.next;
            rl2 = rl2==null ? null : rl2.next;
        }
        if(carry!=0){
            return dummy;
        }
        return dummy.next;
    }
}
