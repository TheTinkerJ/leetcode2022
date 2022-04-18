package org.example.leetcode;

public class T24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode fast = head;
        ListNode slow = dummy;
        while(fast != null){
            // 节点数小于等于1个的话,就没法玩
            if(fast == null || fast.next == null){
                break;
            }
            fast = fast.next.next;
            ListNode first = slow.next;
            ListNode second = slow.next.next;
            slow.next = second;
            second.next = first;
            first.next = fast;
            slow = slow.next.next;
        }
        return dummy.next;
    }

}
