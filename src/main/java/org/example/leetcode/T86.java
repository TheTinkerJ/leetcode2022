package org.example.leetcode;

public class T86 {

    public ListNode tail(ListNode head){
        ListNode current = head;
        while(current != null && current.next != null){
            current = current.next;
        }
        return current;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyLeft = new ListNode(0,null);
        ListNode dummyLeftTail = dummyLeft;
        ListNode dummyRight = new ListNode(0,null);
        ListNode dummyRightTail = dummyRight;

        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next = null;
            if(current.val < x){
                dummyLeftTail.next = current;
                dummyLeftTail = dummyLeftTail.next;
            }else{
                dummyRightTail.next = current;
                dummyRightTail = dummyRightTail.next;
            }
            current = next;
        }
        dummyLeftTail.next = dummyRight.next;
        return dummyLeft.next;
    }
}
