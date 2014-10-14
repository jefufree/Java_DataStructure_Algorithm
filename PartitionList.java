/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        /*
        ListNode cur=head;
       if(head==null||head.next==null) return head;
       if(head.val<x){
        while(cur.next.val<x&&cur.next!=null){
           cur=cur.next;
           if(cur.next==null) return head;
             }
       }
        ListNode part=cur;
        while(cur.next!=null){
         if(cur.next.val<x){
        ListNode temp=cur.next;
        cur.next=cur.next.next;
        temp.next=part.next;
        part.next=temp;
         part=part.next;
          }
          cur=cur.next;
          if(cur==null) break;
          }
         return head; 
         */
         
         
     
        if (head == null) {
            return null;
        }
        
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;
        
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
  
    }
}
