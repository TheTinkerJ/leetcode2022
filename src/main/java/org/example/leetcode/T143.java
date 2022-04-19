package org.example.leetcode;

public class T143 {

    public int listSize(ListNode currnet){
        int count = 0;
        while(currnet!=null){
            currnet = currnet.next;
            count += 1;
        }
        return count;
    }

    public ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(0);
        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = next;
        }
        return dummy.next;
    }

    public void reorderList(ListNode head) {
        int size = listSize(head);
        int half = size/2;
        ListNode split = head;
        while(half>0){
            split = split.next;
            half--;
        }
        ListNode nextPart = split.next;
        split.next = null;
        ListNode rightHalf = reverse(nextPart);
        ListNode current = head;
        ListNode rightPtr = rightHalf;
        while(rightPtr!=null) {
            ListNode third = current.next;

            current.next = rightPtr;
            rightPtr = rightPtr.next;

            current.next.next = third;
            current = third;
        }
    }

    public static void main(String[] args) {
        new T143().reorderList(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))));
    }
}
