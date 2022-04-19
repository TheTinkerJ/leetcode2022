package org.example.leetcode;

public class T92 {
    // 1 <= left <= right <= n
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0,head);
        ListNode leftFrom = dummy;
        ListNode rightTo = dummy;
        for (int i = 1; i < left; i++) {
            leftFrom = leftFrom.next;
        }
        for (int i = 0; i < right; i++) {
            rightTo = rightTo.next;
        }
        ListNode leftHead = leftFrom.next;
        ListNode restHead = rightTo.next;
        rightTo.next = null;

        ListNode newHead = reverseWithTail(leftHead,restHead);
        leftFrom.next = newHead;
        return dummy.next;
    }

    public ListNode reverseWithTail(ListNode head,ListNode tail){
        ListNode dummy = new ListNode(0,tail);
        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = next;
        }
        return dummy.next;
    }

}
