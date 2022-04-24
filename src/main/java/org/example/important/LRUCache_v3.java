package org.example.important;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_v3 {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(){}

        Node(int key,int value){
            this.key = key;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        LRUCache_v3 cache = new LRUCache_v3(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
    }

    int size,capacity;
    Map<Integer,Node> cache;
    Node head;
    Node tail;

    public LRUCache_v3(int capacity){
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void addToHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }


    public void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void moveToHead(Node node){
        remove(node);
        addToHead(node);
    }


    public int get(int key) {
        if(cache.containsKey(key)) {
            Node current = cache.get(key);
            moveToHead(current);
            return current.value;
        }
        return -1;
    }

    public void put(int key,int value){
        if(cache.containsKey(key)){
            Node current = cache.get(key);
            current.value = value;
            moveToHead(current);
        }else{
            Node toAdd = new Node(key,value);
            if(size == capacity){
                Node toDelete = tail.prev;
                remove(toDelete);
                cache.remove(toDelete.key);
                size--;
            }
            addToHead(toAdd);
            cache.put(key,toAdd);
            size++;
        }
    }

}
