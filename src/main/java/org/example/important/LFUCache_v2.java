package org.example.important;

import java.util.Map;
import java.util.HashMap;

public class LFUCache_v2 {
    public static void main(String[] args) {
        LFUCache_v2 cache = new LFUCache_v2(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.get(3);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
    int minFreq,capacity;
    Map<Integer,Node> keyTable;
    Map<Integer,DLinkedList> freqTable;

    public LFUCache_v2(int capacity){
        this.minFreq = 0;
        this.capacity = capacity;
        keyTable = new HashMap<>();
        freqTable = new HashMap<>();
    }

    public int get(int key){
        if(!keyTable.containsKey(key)){
            return -1;
        }
        Node keyNode = keyTable.get(key);
        int value = keyNode.value;
        int freq = keyNode.freq;
        DLinkedList oldList = freqTable.get(freq);
        oldList.remove(keyNode);
        if(oldList.size==0){
            freqTable.remove(freq);
            if(freq==minFreq){
                minFreq +=1;
            }
        }
        freq += 1;
        keyNode.freq = freq;
        DLinkedList newList = freqTable.getOrDefault(freq,new DLinkedList());
        newList.addFirst(keyNode);
        freqTable.put(freq,newList);
        return value;
    }

    public void put(int key,int value){
        if(capacity==0){
            return;
        }
        if(!keyTable.containsKey(key)){
            if(keyTable.size()==capacity){
                DLinkedList minList = freqTable.get(minFreq);
                Node nodeToDelete = minList.getTail();
                keyTable.remove(nodeToDelete.key);
                minList.remove(nodeToDelete);
                if(minList.size==0){
                    freqTable.remove(minFreq);
                }
            }
            Node nodeToAdd = new Node(key, value,1);
            DLinkedList freqOneList = freqTable.getOrDefault(1,new DLinkedList());
            freqOneList.addFirst(nodeToAdd);
            freqTable.put(1,freqOneList);
            keyTable.put(key, nodeToAdd);
            minFreq=1;
        }else{
            Node node = keyTable.get(key);
            int freq = node.freq;
            DLinkedList list = freqTable.get(freq);
            list.remove(node);
            if(list.size==0){
                freqTable.remove(freq);
                if(freq==minFreq){
                    minFreq+=1;
                }
            }
            freq += 1;
            node.value = value;
            node.freq = freq;
            DLinkedList newFreqList = freqTable.getOrDefault(freq,new DLinkedList());
            newFreqList.addFirst(node);
            freqTable.put(freq,newFreqList);
        }
    }

    class Node{
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(){
            this(-1,-1,0);
        }

        Node(int key,int value,int freq){
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    class DLinkedList{
        Node dummyHead;
        Node dummyTail;
        int size;

        DLinkedList(){
          dummyHead = new Node();
          dummyTail = new Node();
          dummyHead.next = dummyTail;
          dummyTail.prev = dummyHead;
          size = 0;
        }

        public void addFirst(Node node){
            Node next = dummyHead.next;
            next.prev = node;
            node.next = next;
            node.prev = dummyHead;
            dummyHead.next = node;
            size ++ ;
        }

        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size -- ;
        }

        public Node getHead(){
            return dummyHead.next;
        }

        public Node getTail(){
            return dummyTail.prev;
        }
    }
}
