class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int count1=0;
        Integer majorityele1=null;
        int count2=0;
        Integer majorityele2=null;
        for(int i=0;i<n;i++){
            if(majorityele1!=null && nums[i]==majorityele1){
                count1++;
            }else if(majorityele2!=null && nums[i]==majorityele2){
                count2++;
            }else if(count1==0){
                majorityele1=nums[i];
                count1=1;
            }else if(count2==0){
                majorityele2=nums[i];
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        //verification phase
        List<Integer> res=new ArrayList<>();
        int freq1=0;
        int freq2=0;
        for(int num:nums){
            if(majorityele1 !=null && num==majorityele1){
                freq1++;
            }else if(majorityele2!=null &&num==majorityele2){
                freq2++;
            }
        }
        if(freq1>n/3)res.add(majorityele1);
        if(freq2>n/3)res.add(majorityele2);
        return res;
    }
}