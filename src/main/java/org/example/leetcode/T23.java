package org.example.leetcode;

public class T23 {

    public ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0,null);
        ListNode tail = dummy;
        while(l1!=null && l2 != null){
            int a = l1.val;
            int b = l2.val;
            if( a <= b){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if( l1 != null || l2 != null){
            tail.next = l1 != null ? l1 : l2;
        }
        return  dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int lo,int hi){
        if(lo==hi){
            return lists[lo];
        }
        int mid = lo + (hi-lo)/2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid+1, hi);
        return mergeTwoList(l1,l2);
    }
}
