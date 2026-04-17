class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int complement=target-nums[i];
            if(mp.containsKey(complement)){
                return new int[]{mp.get(complement),i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{};
    }
}