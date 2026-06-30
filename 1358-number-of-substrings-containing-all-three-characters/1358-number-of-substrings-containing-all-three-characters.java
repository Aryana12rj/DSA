class Solution {
    public int numberOfSubstrings(String s) {
        int fre[]=new int[3];
        int count=0;
        int currcount=0;
        int left=0;
        int n=s.length();

        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            fre[ch-'a']++;
            if(fre[ch-'a']==1){
                currcount++;
            }
            while(currcount==3){
                count+=(n-right);
                char cha=s.charAt(left);
                fre[cha-'a']--;
                if(fre[cha-'a']==0){
                    currcount--;
                }
                left++;
            }
        }
        return count;
    }
}