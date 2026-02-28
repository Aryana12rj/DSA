class Solution {
    public int concatenatedBinary(int n) {
        final int MOD=1_000_000_007;
        long res=0;
        for(int i=1;i<=n;i++){
            res=((res<<Noofbits(i))%MOD+i)%MOD;

        }
        return (int) res;
    }
    
    private int Noofbits(int n){
        return (int)(Math.log(n)/Math.log(2))+1;
    }
}