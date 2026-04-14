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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        for(ListNode a=headA;a!=null;a=a.next){
            for(ListNode b=headB;b!=null;b=b.next){
                if(a==b)return a;
            }
        }
        return null;
    }
}