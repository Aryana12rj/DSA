class Solution {
    public int largestAltitude(int[] gain) {
        int max1=0;
        int sum1=0;
        for(int i=0;i<gain.length;i++){
            sum1+=gain[i];
            max1=Math.max(max1,sum1);
        }
        return max1;
    }
}