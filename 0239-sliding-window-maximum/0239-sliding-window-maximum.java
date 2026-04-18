class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        //store index
        Deque<Integer> q=new ArrayDeque<>();
        int[] result=new int[n-k+1];
        int resi=0;
        for(int i=0;i<n;i++){
            //remove no out of range k
            while(!q.isEmpty()&&q.peek()<i-k+1){
                q.poll();

            }
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i>=k-1){
                result[resi++]=nums[q.peek()];
            }
        }
        return result;

    }
}