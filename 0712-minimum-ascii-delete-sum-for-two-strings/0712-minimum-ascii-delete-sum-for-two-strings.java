class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        Integer[][] memo = new Integer[n][m];

        int lcssum=dfs(s1,s2,0,0,memo);
        int total=0;
        for(char c: s1.toCharArray()) total+=c;
        for(char c: s2.toCharArray()) total+=c;
        return total-2*lcssum;
    }
    private int dfs(String s1,String s2,int i,int j,Integer[][] memo){
        if(i==s1.length()||j==s2.length()) return 0;
        if(memo[i][j]!=null) return memo[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            memo[i][j]=s1.charAt(i)+dfs(s1,s2,i+1,j+1,memo);
        }else{
            memo[i][j]=Math.max(dfs(s1,s2,i+1,j,memo),dfs(s1,s2,i,j+1,memo));
        }
        return memo[i][j];
    }
}