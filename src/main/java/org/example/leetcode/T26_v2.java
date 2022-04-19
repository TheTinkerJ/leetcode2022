package org.example.leetcode;

public class T26_v2 {

    public int listSize(ListNode head){
        ListNode current = head;
        int count = 0;
        while(current!=null){
            current = current.next;
            count += 1;
        }
        return count;
    }

    public ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(0,null);
        ListNode tail = head;
        while(tail!=null){
            ListNode next = tail.next;
            tail.next = dummy.next;
            dummy.next = tail;
            tail = next;
        }
        return dummy.next;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int size = listSize(head);
        if(size <= 1 || k % size == 0 ){
            return head;
        }
        int kMove = k % size;

        ListNode reversedHead = reverse(head);
        ListNode fast = reversedHead;
        ListNode slow = new ListNode(0,reversedHead);
        while( kMove > 0 ){
            fast = fast.next;
            slow = slow.next;
            kMove--;
        }
        slow.next = null;
        ListNode left = reverse(reversedHead);
        ListNode right = reverse(fast);
        reversedHead.next = right;
        return left;
    }
}
