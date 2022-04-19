package org.example.leetcode;

public class T82 {

    public ListNode deleteDuplicates0419(ListNode head){
        ListNode dummy = new ListNode(-101,head);
        ListNode fast = head;
        ListNode slow = dummy;
        while(fast!=null && fast.next!=null){
            if(fast.val == fast.next.val){
                int x = fast.val;
                while(fast!=null && fast.val == x){
                    fast = fast.next;
                }
            }else{
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        if(fast!=null){
            slow.next = fast;
        }else{
            slow.next = null;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicatesV2(ListNode head) {
        ListNode dummy = new ListNode(-101,head);
        ListNode fast = head;
        ListNode slow = dummy;

        while( fast != null && fast.next != null ) {
            if(fast.val == fast.next.val){
                int x = fast.val;
                fast = fast.next.next;
                while(fast != null && fast.val == x){
                    fast = fast.next;
                }
            }else{
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        if(fast != null){
            slow.next = fast;
        }else{
            slow.next = null;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101,head);
        ListNode fast = head;
        ListNode slow = dummy;

        int current = -101;
        int count = 0;
        while( fast != null ) {
            if(fast.val != current){
                if(count == 1){
                    slow = slow.next;
                }else{
                    slow.next = fast;
                }
                current = fast.val;
                count = 1;
            }else{
                slow.next = fast.next;
                count += 1;
            }
            fast = fast.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        new T82().deleteDuplicates(new ListNode(1,new ListNode(1)));
    }
}
