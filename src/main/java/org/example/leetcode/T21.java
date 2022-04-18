package org.example.leetcode;

public class T21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0,null);
        ListNode tail = dummy;
        while( list1 != null && list2 != null ){
            int a = list1.val;
            int b = list2.val;
            if ( a <= b ){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            /**
             * what I forget
             */
            tail = tail.next;
        }
        if(list1 != null || list2 != null){
            tail.next = list1 != null ? list1 : list2;
        }
        return dummy.next;
    }
}
