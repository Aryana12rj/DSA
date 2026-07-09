class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] complement=new int[n];
        complement[0]=0;

        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff){
                complement[i]=complement[i-1];
            }else{
                complement[i]=complement[i-1]+1;
            }

        }
        boolean[] answer =new boolean [queries.length];

        for(int i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            answer[i]=(complement[u]==complement[v]);
        }
        return answer;
    }
}