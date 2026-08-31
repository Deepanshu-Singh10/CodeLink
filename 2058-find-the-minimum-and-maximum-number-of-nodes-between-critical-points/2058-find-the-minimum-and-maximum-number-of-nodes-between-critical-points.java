/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        if(size<=2) return new int[]{-1,-1};
        int index = 0;
        int [] result = new int[2];
        ListNode curr = head;
        ListNode prev = curr;
        List <Integer> distance = new ArrayList<>();
        for(int i = 1;i<size;i++){
            if(i>1){
                if(prev.val>curr.val&&curr.next.val>curr.val){
                    distance.add(i);
                }
                else if(prev.val<curr.val&& curr.next.val<curr.val){
                    distance.add(i);
                }
                prev = curr;
            }
            curr = curr.next;
        }
        
        if(distance.size()<2) return new int []{-1,-1};
         
         int minDist = Integer.MAX_VALUE;
         for(int k=1;k<distance.size();k++){
            minDist = Math.min(minDist,distance.get(k)-distance.get(k-1));
         }
        result[0] = minDist;
        result[1] = distance.get(distance.size()-1) - distance.get(0);
      
        return result;
    }
}