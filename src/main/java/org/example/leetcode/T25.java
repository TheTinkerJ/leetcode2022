package org.example.leetcode;

public class T25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;
        while(fast != null){
            boolean canReverse = true;
            for(int i=0; i < k-1 ; i++){
                fast = fast.next;
                if(fast == null){
                    canReverse = false;
                    break;
                }
            }

            if(!canReverse){
                break;
            }

            ListNode nextFast = fast.next;
            ListNode nextSlow = slow.next;
            fast.next = null;

            ListNode subHead = reverseWithTail(slow.next,nextFast);

            slow.next = subHead;

            fast = nextFast;
            slow = nextSlow;
        }
        return dummy.next;
    }

    public ListNode reverseWithTail(ListNode head,ListNode tail){
        ListNode dummy = new ListNode(0,tail);
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = next;
        }
        return dummy.next;
    }
}
