package org.example.leetcode;

/**
 * 约束比较多,值唯一链不唯一,所以还好
 */
public class T237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
