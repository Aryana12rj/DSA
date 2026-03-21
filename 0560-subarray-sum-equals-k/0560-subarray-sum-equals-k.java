class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int prefixsum=0;
        for(int right=0;right<nums.length;right++){
            prefixsum+=nums[right];
            int target=prefixsum-k;
            if(map.containsKey(target)){
                count+=map.get(target);

            }
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);

        }
        return count;
    }
}