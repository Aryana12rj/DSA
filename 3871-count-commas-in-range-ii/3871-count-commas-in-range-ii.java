class Solution {
    public long countCommas(long n) {
        long ans=0;
        for(int i=3;i<16;i+=3){
            long base=(long)Math.pow(10,i);
            if(n<base){
                break;
            }
            ans+= n-base+1;
        }
        return ans;
    }
}