package org.example.leetcode;

/**
 * 很有技巧性和那个什么很像
 * - > 和142差不多
 */
public class T160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        while(ptrA != ptrB ){
            ptrA = ptrA==null ? headB : ptrA.next;
            ptrB = ptrB==null ? headA : ptrB.next;
        }
        return  ptrA;
    }
}
