package org.example.important;


import java.util.HashMap;
import java.util.Map;
/**
 * 回头学到二叉树再来写
 */
public class LFUCache  {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
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

    public LFUCache (int capacity){
        this.minFreq = 0;
        this.capacity = capacity;
        keyTable = new HashMap<>();
        freqTable = new HashMap<>();
    }

    public int get(int key) {
        if(capacity==0){
            return -1;
        }
        if(!keyTable.containsKey(key)){
            return -1;
        }
        Node node = keyTable.get(key);
        int val = node.val;
        int freq = node.freq;
        freqTable.get(freq).remove(node);
        if(freqTable.get(freq).size==0){
            freqTable.remove(freq);
            if(minFreq==freq){
                minFreq += 1;
            }
        }
        freq+=1;
        node.freq = freq;
        DLinkedList list = freqTable.getOrDefault(freq,new DLinkedList());
        list.addFirst(node);
        freqTable.put(freq,list);
        keyTable.put(key,node);
        return val;
    }


    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(!keyTable.containsKey(key)){
            // 删除
            if(keyTable.size()==capacity){
                DLinkedList minList = freqTable.get(minFreq);
                Node nodeToDelete = minList.getTail();

                keyTable.remove(nodeToDelete.key);
                minList.remove(nodeToDelete);
                if(minList.size==0){
                    freqTable.remove(minFreq);
                }
            }
            DLinkedList list = freqTable.getOrDefault(1,new DLinkedList());
            Node nOne = new Node(key,value,1);
            list.addFirst(nOne);
            keyTable.put(key,nOne);
            freqTable.put(1,list);
            minFreq = 1;
        }else{
            Node node = keyTable.get(key);
            int freq = node.freq;
            DLinkedList currentDList = freqTable.get(freq);
            currentDList.remove(node);

            if(currentDList.size==0){
                freqTable.remove(freq);
                if(minFreq==freq){
                    minFreq+=1;
                }
            }
            freq+=1;
            node.freq = freq;
            node.val = value;
            DLinkedList list = freqTable.getOrDefault(freq,new DLinkedList());
            list.addFirst(node);
            freqTable.put(freq,list);
            keyTable.put(key,node);
        }
    }

    class Node {
        int key,val,freq;
        Node prev,next;

        Node (){
            this(-1,-1,0);
        }

        Node(int key,int value,int freq){
            this.key = key;
            this.val = value;
            this.freq= freq;
        }
    }

    class DLinkedList{
        Node dummyHead,dummyTail;
        int size;

        DLinkedList(){
            dummyHead = new Node();
            dummyTail = new Node();
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
            size = 0;
        }

        public void remove(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size --;
        }
        public void addFirst(Node node){
            Node next = dummyHead.next;
            next.prev = node;
            dummyHead.next = node;
            node.next = next;
            node.prev = dummyHead;
            size ++;
        }

        public Node getHead(){
            return dummyHead.next;
        }
        public Node getTail(){
            return dummyTail.prev;
        }

    }
}
