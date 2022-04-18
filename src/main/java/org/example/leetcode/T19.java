package org.example.leetcode;


public class T19 {

    /**
     * 快慢指针法
     * 这里的技巧相当于就是增加了一个前置节点,来解决获取目标节点前一个节点的问题
     * 增加哨兵确实问题简单了很多
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode zero = new ListNode(0,head);
        ListNode fast = head;
        ListNode slow = zero;
        for (int i=0;i<n;i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        ListNode ans = zero.next;
        return ans;
    }

    public static void main(String[] args) {

    }
}
