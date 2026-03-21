class Solution {
    public int countCommas(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            //digit count
            int digit=(int)(Math.log10(i))+1;
            //comma based on digit length
            ans+=(digit-1)/3;
        }
        return ans;
    }
}