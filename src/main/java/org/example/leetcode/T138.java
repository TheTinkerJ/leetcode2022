package org.example.leetcode;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**
 * 链表的复制
 * - 经典题目
 * - 想起来复制一层,然后迁移出去
 */
public class T138 {
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Node current = head;
        while(current!=null) {
            Node add = new Node(current.val);
            Node next = current.next;
            current.next = add;
            add.next = next;
            current =next;
        }

        current = head;
        while(current!=null && current.next!=null){
            if(current.random!=null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        current = head;
        Node dummy = new Node(0);
        Node tail = dummy;
        while(current!=null && current.next!=null){
            Node jumpTo = current.next.next;
            tail.next = current.next;
            tail = tail.next;
            current.next = jumpTo;
            current = jumpTo;
        }
        return dummy.next;
    }
}
