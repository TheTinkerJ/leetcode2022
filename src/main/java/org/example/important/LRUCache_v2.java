package org.example.important;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_v2 {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode next;
        DLinkedNode prev;
        public DLinkedNode(){}

        public DLinkedNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer,DLinkedNode> cache = new HashMap<>();
    int size;
    int capacity;
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache_v2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }


    public void addToHead(DLinkedNode node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

    }

    public void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            DLinkedNode current = cache.get(key);
            moveToHead(current);
            return current.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            DLinkedNode current = cache.get(key);
            moveToHead(current);
            current.value = value;
        }else{
            DLinkedNode node = new DLinkedNode(key,value);
            if(size+1>capacity){
                DLinkedNode last = tail.prev;
                removeNode(last);
                cache.remove(last.key);
            }else{
                size++;
            }
            addToHead(node);
            cache.put(key,node);
        }
    }

}
