class Solution {
    public int minOperations(int[] nums) {
        
        int n=nums.length;
        if(n==1) return 0;
        int first=nums[0];
        int last=nums[n-1];
        int gtl=0;
        int gtr=0;
        for(int i=0;i<n-1;i++)
            {
                if(nums[i]>nums[i+1]) gtl++;
            }
        for(int i=n-1;i>=1;i--)
            {
                if(nums[i-1]<nums[i]) gtr++;
            }
        if(first<last && gtl==0) return 0;
        else if(first>last && gtr==0) return 1;
        else if((first>last && gtl>1) || (first<last && gtr>1)) return -1;
        else if(first>last && gtl==1)
        {
            int pos=-1;
            for(int i=0;i<nums.length-1;i++)
                {
                    if(nums[i]>nums[i+1])
                    {
                        pos=i;
                        break;
                    }
                }
            return Math.min(pos+1,n-1-pos+1+1);
        }
        else if(first<last && gtr==1)
        {
            int pos=-1;
            for(int i=n-1;i>=0;i--)
                {
                    if(nums[i-1]<nums[i])
                    {
                        pos=i;
                        break;
                        
                    }
                }
            return Math.min(pos+1,n-pos+1);
        }
        else return -1;
    }
}