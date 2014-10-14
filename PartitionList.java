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
        ListNode cur=head;
        if(head==null||head.next==null) return head;
        while(cur.next.val<x&&cur.next!=null){
            cur=cur.next;
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
        }
        return head;
    }
}
