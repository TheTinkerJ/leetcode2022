package org.example.t0417;

import org.example.leetcode.ListNode;

import java.util.List;

public class T2 {

    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = head;

        int carry = 0;
        while( l1!=null || l2!=null){
            int a = l1==null ? 0 : l1.val;
            int b = l2==null ? 0 : l2.val;
            int sum = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;

            ListNode next = new ListNode(sum);
            if(tail==null){
                head = next;
            }else{
                tail.next = next;
            }
            tail = next;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }
        if(carry!=0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
