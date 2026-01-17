class Solution {
//     // Algorithm: Iterate through the array, each time all elements to the left are smaller (or equal) to all elements to the right, there is a new chunck.
// Use two arrays to store the left max and right min to achieve O(n) time complexity. Space complexity is O(n) too.
// This algorithm can be used to solve ver1 too.
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int[] maxleft=new int[n];
        int[] minofright=new int[n];

        maxleft[0]=arr[0];
        for(int i=1;i<n;i++){
            maxleft[i]=Math.max(maxleft[i-1],arr[i]);
        }
        minofright[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            minofright[i]=Math.min(minofright[i+1],arr[i]);

        }
        int res=0;
        for(int i=0;i<n-1;i++){
            if(maxleft[i]<=minofright[i+1]){
                res++;
            }
        }
        return res+1;


    }
}