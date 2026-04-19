class Solution {
    public void dfs(int[][] image,int i,int j,int newcolor,int oldcolor){
        if(i<0||i>=image.length || j<0 || j>=image[0].length ||image[i][j]!=oldcolor||image[i][j]==newcolor ){
            return;
        }
        image[i][j]=newcolor;
        dfs(image,i,j+1,newcolor,oldcolor);//right
        dfs(image,i-1,j,newcolor,oldcolor);//top
        dfs(image,i+1,j,newcolor,oldcolor);//bottom
        dfs(image,i,j-1,newcolor,oldcolor);//left

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }
}