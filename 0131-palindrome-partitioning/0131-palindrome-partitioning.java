class Solution {
    public List<List<String>> partition(String s) {
        int n=s.length();

        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)&& (len==2||dp[i+1][j-1])){
                    dp[i][j]=true;
                }
            }
        }
        List<List<String>> res=new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),res,dp);
        return res;

    }
    private void backtrack(String s,int start,List<String> path,List<List<String>> res,boolean[][] dp){
        if(start==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int end=start;end<s.length();end++){
            if(dp[start][end]){
                path.add(s.substring(start,end+1));
                backtrack(s,end+1,path,res,dp);
                path.remove(path.size()-1);
            }
        }
    }
}