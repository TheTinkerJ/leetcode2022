package org.example.leetcode;

public class T369 {
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

    public ListNode plusOne(ListNode head) {
        ListNode l0 = reverse(head);
        ListNode l1 = new ListNode(1);

        ListNode ptr0 = l0;
        ListNode ptr1 = l1;
        ListNode dummy = new ListNode(0);
        int carry = 0;
        while(ptr1 != null || ptr0 != null){
            int a = ptr0 == null ? 0 : ptr0.val;
            int b = ptr1 == null ? 0 : ptr1.val;
            int sum = (a+b+carry) % 10;
            carry = (a+b+carry) / 10;

            ListNode current = new ListNode(sum);
            current.next = dummy.next;
            dummy.next = current;
            ptr0 = ptr0 == null?null:ptr0.next;
            ptr1 = ptr1 == null?null:ptr1.next;
        }
        if(carry!=0){
            dummy.val = 1;
            return dummy;
        }else{
            return dummy.next;
        }
    }
}
