class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m=g.length;
        int n=s.length;
        if(n==0){
            return 0;
        }
        int i=0,j=0;

        while(i<m && j<n){
            if(g[i]<=s[j]){//satisfy condition
                i++;
            }
            j++;
        }
        return i;



    }
}