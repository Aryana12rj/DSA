class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charcount=new int[26];

        for(char ch:chars.toCharArray()){
            charcount[ch-'a']++;
        }
        int res=0;

        for(String word:words){
            int[] wordcount=new int[26];
            for(char ch:word.toCharArray()){
                wordcount[ch-'a']++;
            }
            boolean notpossible=true;
            for(int i=0;i<26;i++){
                if(wordcount[i]>charcount[i]){
                    notpossible=false;
                    break;
                }
            }
            if(notpossible==true){
                res+=word.length();
            }
        }
        return res;
    }
}