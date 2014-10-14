/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode cur=new TreeNode(slow.val);
        cur.left=find(head,slow);
        cur.right=find(slow.next,fast);
        return cur;
    }
    
    public TreeNode find(ListNode start,ListNode end){
        if(start==end) return null;
        /*
        if(start.next==end){
            return new TreeNode(start.val);
        }
        */
        ListNode fast=start;
        ListNode slow=start;
        while(fast!=end.next&&fast.next!=end.next){
             fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode n=new TreeNode(slow.val);
        n.left=find(start,slow);
        n.right=find(slow.next,end);
        return n;
    }
}
