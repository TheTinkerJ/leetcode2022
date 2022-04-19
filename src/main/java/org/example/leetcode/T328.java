package org.example.leetcode;

public class T328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy0 = new ListNode(0,null);
        ListNode tail0 = dummy0;
        ListNode dummy1 = new ListNode(1,null);
        ListNode tail1 = dummy1;
        ListNode current = head;
        int idx = 0;
        while(current!=null){
            ListNode next = current.next;
            if( idx%2 == 0){
                tail0.next = current;
                tail0 = tail0.next;
            }else{
                tail1.next = current;
                tail1 = tail1.next;
            }
            idx += 1 ;
            current = next;
        }
        tail0.next = dummy1.next;
        tail1.next = null;
        return dummy0.next;
    }
}
