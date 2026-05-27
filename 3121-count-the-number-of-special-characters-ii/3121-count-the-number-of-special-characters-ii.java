class Solution {
    public int numberOfSpecialChars(String word) {
        int n=word.length();
        int [] lower= new int [26];
        int [] upper=new int [26];
        Arrays.fill(lower,-1);
        Arrays.fill(upper,-1);
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            if(Character.isLowerCase(ch)){
                lower[ch-'a']=i;
            }else{
                if(upper[ch -'A']==-1){
                upper[ch-'A']=i;
                }
            }
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(upper[i]!=-1 && lower[i]!=-1 && lower[i]<upper[i]){
                count++;
            }
        }
        return count;
    }
}