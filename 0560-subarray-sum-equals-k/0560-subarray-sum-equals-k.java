class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int count=0;
        int prefixsum=0;
        for(int right=0;right<n;right++){
            prefixsum+=nums[right];
            int target=prefixsum-k;
            if(mp.containsKey(target)){
                count+=mp.get(target);
            }
            mp.put(prefixsum,mp.getOrDefault(prefixsum,0)+1);

        }
        return count;
    }
}