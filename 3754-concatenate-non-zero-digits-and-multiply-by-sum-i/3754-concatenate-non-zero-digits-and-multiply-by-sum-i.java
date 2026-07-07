class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long digi=0;
        while (n!=0){
            if(n%10!=0){
                sum+=n%10;
                digi=digi*10+n%10;
            }
            n=n/10;
        }
        return rev(digi)*sum;
    }
    public long rev(long n){
        long re=0;
        while (n!=0){
            re=re*10+n%10;
            n=n/10;
        }
        return re;
    }
}