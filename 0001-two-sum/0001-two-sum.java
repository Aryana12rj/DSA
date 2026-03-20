class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int diff=target-nums[i];
        
        if(mp.containsKey(diff)){
            return new int[]{mp.get(diff),i};
        }
        mp.put(nums[i],i);
        }
        return null;

    }
}