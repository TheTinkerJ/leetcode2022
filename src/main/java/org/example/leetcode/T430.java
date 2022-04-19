package org.example.leetcode;

/**
 * 展开的时候,他的下一个节点可能时 next 也可能是 child
 * 时间复杂度 o(n) 的一次遍历
 * 空间复杂度 o(n) 的栈空间
 */

public class T430 {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if(head==null){
            return head;
        }
        adjust(head);
        return head;
    }


    public Node adjust(Node node){
        Node current = node;
        while(current.next!=null || current.child!=null){
            Node next = current.next;
            if(current.child!=null){
                Node child = current.child;
                Node tail = adjust(child);
                if(next!=null){
                    tail.next = next;
                    next.prev = tail;
                }
                current.next = child;
                child.prev = current;
                current.child = null;
            }
            current = current.next;
        }
        return current;
    }

}
