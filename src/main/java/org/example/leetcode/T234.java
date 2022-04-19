package org.example.leetcode;

import java.util.List;

public class T234 {

    public int listSize(ListNode head) {
        ListNode current = head;
        int size = 0;
        while(current!=null){
            current = current.next;
            size += 1;
        }
        return size;
    }

    public ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(0,null);
        ListNode current = head;
        while (current!=null){
            ListNode next = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = next;
        }
        return dummy.next;
    }

    public boolean isPalindrome(ListNode head) {
        int size = listSize(head);
        if(size<=1){
            return true;
        }
        int half = (size-1)/2;
        ListNode skip = head;
        while (half > 0){
            skip = skip.next;
            half--;
        }

        ListNode rightReversed = reverse(skip.next);
        ListNode currentRight = rightReversed;
        ListNode currentLeft = head;
        boolean matched = true;
        while(currentRight!=null){
            if(currentRight.val !=currentLeft.val){
                matched = false;
                break;
            }
            currentLeft = currentLeft.next;
            currentRight = currentRight.next;
        }
        return matched;
    }
}
