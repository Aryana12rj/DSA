class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length; long maxArea = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int left = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int right = Math.min(topRight[i][0], topRight[j][0]);
                int top = Math.min(topRight[i][1], topRight[j][1]);
                int bottom = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                if(left < right && top > bottom){
                    int height = top - bottom; int width = right - left;
                    int side = Math.min(height, width);
                    maxArea = Math.max(maxArea, 1L * side * side);
                }   
            }
        }
        return maxArea;
    }
}
