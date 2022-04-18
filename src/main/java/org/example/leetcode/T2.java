package org.example.leetcode;


public class T2 {

    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = head;

        int incrment = 0;
        while(l1 != null || l2!= null){
            int a = l1==null ?0 : l1.val;
            int b = l2==null ?0 : l2.val;
            int r = (a + b + incrment) % 10;
            incrment = (a + b+ incrment) >= 10? 1 : 0;

            ListNode next = new ListNode(r);
            if(tail==null){
                head = next;
            }else{
                tail.next = next;
            }
            tail = next;
            l1 = l1==null ? null : l1.next;
            l2 = l2==null ? null : l2.next;
        }
        if(incrment!=0){
            ListNode next = new ListNode(incrment);
            tail.next = next;
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = null;
        int r = 0;
        int incrment = 0;
        while(l1 != null && l2!= null){
            int a = l1.val;
            int b = l2.val;

            r = (a + b + incrment) % 10;
            incrment = (a + b+ incrment) >= 10? 1 : 0;

            ListNode next = new ListNode(r);
            if(current==null){
                head.next = next;
            }else{
                current.next = next;
            }
            current = next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int v = l1.val;
            r = (v + incrment) % 10;
            incrment = (v + incrment) >= 10? 1 : 0;
            ListNode next = new ListNode(r);
            if(current==null){
                head.next = current;
            }else{
                current.next = next;
            }
            current = next;
            l1 = l1.next;
        }

        while(l2 != null){
            int v = l2.val;
            r = (v + incrment) % 10;
            incrment = (v + incrment) >= 10? 1 : 0;
            ListNode next = new ListNode(r);
            if(current==null){
                head.next = current;
            }else{
                current.next = next;
            }
            current = next;
            l2 = l2.next;
        }
        if(incrment!=0){
            ListNode next = new ListNode(incrment);
            current.next = next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode result = new T2().addTwoNumbers(l1,l2);
        System.out.printf("");
    }
}
