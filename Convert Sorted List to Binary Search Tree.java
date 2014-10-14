/**
 * /**
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
        ListNode rail=head;
        while(rail.next!=null){
            rail=rail.next;
        }
        return find(head,rail);
        /*
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
        */
    }
    
    public TreeNode find(ListNode start,ListNode end){
        if(start==end) return new TreeNode(start.val);
        /*
        if(start.next==end){
            return new TreeNode(start.val);
        }
        */
        ListNode fast=start;
        ListNode slow=start;
        ListNode preslow=start;
        while(fast!=end&&fast.next!=end){
             fast=fast.next.next;
             if(fast==end||fast.next==end) preslow=slow;
            slow=slow.next;
        }
        TreeNode n=new TreeNode(slow.val);
        
        if(slow==start){
            n.left=null;
            n.right=new TreeNode(end.val);
        }else{
        
        n.left=find(start,preslow);
        n.right=find(slow.next,end);
        }
        return n;
    }
}
