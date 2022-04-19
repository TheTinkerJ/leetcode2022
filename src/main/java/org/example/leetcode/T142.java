package org.example.leetcode;

/**
 * 说实话再写一遍还真不一定写对
 *  三辆车
 *  - 两辆同时出发
 *  - 第三辆相遇时出发
 *
 *  这里有数学原理
 *  - 第一次相遇
 *  - 第二次相遇
 *  - 为什么一定能够在第一圈就相遇
 */
public class T142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean existCycle = false;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast!=null && fast == slow){
                ListNode ptr = head;
                while(slow!=ptr){
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
