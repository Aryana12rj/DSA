class Solution{
   public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        int count = 0, maxarr = 0;
        for (int i = 0; i < arr.length; i++) {
            maxarr = Math.max(maxarr, arr[i]);
            if (maxarr == i) {
                count++;
            }
        }
        
        return count;
    }
}