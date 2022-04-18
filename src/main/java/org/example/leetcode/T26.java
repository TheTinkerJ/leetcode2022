package org.example.leetcode;

public class T26 {
    public ListNode rotateRight(ListNode head, int k) {
        int length = size(head);
        if(length <= 1){
            return head;
        }
        int kMove = k % length;
        if( kMove ==0){
            return head;
        }

        ListNode reversed = reverse(head);
        ListNode fast = reversed;
        ListNode slow = new ListNode(0,reversed);
        while (kMove>0) {
            fast = fast.next;
            slow = slow.next;
            kMove--;
        }

        ListNode p0 = reversed;
        ListNode p1 = slow;
        ListNode p2 = fast;
        p1.next = null;

        ListNode left = reverse(p0);
        ListNode right = reverse(p2);
        p0.next = right;
        return left;
    }

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

    public int size(ListNode head){
        ListNode current = head;
        int sum = 0;
        while(current!=null){
            current = current.next;
            sum += 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode ListNodehead = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode head = new ListNode(1,new ListNode(2,null));
        new T26().rotateRight(head,2);
    }
}
