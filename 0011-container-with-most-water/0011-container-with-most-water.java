class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int maxarea=0;
        while(left<=right){
            int h=Math.min(height[left],height[right]);
            int width=right-left;
            int area=h*width;
            maxarea=Math.max(area,maxarea);

            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
            
        }
        return maxarea;
    }
}