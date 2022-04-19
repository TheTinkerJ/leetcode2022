package org.example.leetcode;

public class T141 {

    /**
     * 快慢节点:
     *  (1) 有时候是距离差
     *  (2) 有时候是速度差
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean existCycle = false;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast!=null && fast == slow){
                existCycle = true;
                break;
            }
        }
        return existCycle;
    }
}
