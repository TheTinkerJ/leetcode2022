package org.example.important;

import java.util.HashMap;
import java.util.Map;

/**
 * 需要同时管理两个状态
 * - hash表
 * - 双向链表, 表头最近使用, 表尾巴最近未使用
 */


public class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer,DLinkedNode> cache = new HashMap<Integer,DLinkedNode>();
    private int size;
    private int capcity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capcity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            DLinkedNode current = cache.get(key);
            moveToHead(current);
            return current.value;
        }else{
            return -1;
        }
    }

    private void moveToHead(DLinkedNode current){
        // adjust to head
        DLinkedNode prev = current.prev;
        DLinkedNode next = current.next;

        prev.next = next;
        next.prev = prev;

        current.next = head.next;
        current.prev = head;
        head.next.prev = current;
        head.next = current;
    }

    private void removeTail(){
        DLinkedNode last = tail.prev;
        cache.remove(last.key);
        last.prev.next = tail;
        tail.prev = last.prev;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            DLinkedNode current = cache.get(key);
            moveToHead(current);
            current.value = value;
        }else{
            DLinkedNode node = new DLinkedNode(key,value);
            if( size + 1 > capcity){
                removeTail();
            }else{
                size+=1;
            }
            cache.put(key,node);

            head.next.prev = node;
            node.prev = head;
            node.next = head.next;
            head.next = node;
        }
    }
}
