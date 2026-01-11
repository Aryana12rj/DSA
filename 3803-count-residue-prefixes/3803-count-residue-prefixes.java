class Solution {
    public int residuePrefixes(String s) {
        int[] fre=new int[26];
        int dis=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            int indx=s.charAt(i)-'a';
            if(fre[indx]==0){
                dis++;
            }
            fre[indx]++;
            if(dis==(i+1)%3){
                ans++;
            }
        }
        return ans;
    }
}