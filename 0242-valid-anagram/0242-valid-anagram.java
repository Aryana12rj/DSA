class Solution {
    public boolean isAnagram(String s, String t) {
        //if length is not same then not valid anagram
        if(s.length()!=t.length()){
            return false;
        }
        //frequency character 
        int[] charcnt=new int[26];
        //for every character increment count for s and decrement length of t
        
        for(int i=0;i<s.length();i++){
            charcnt[s.charAt(i)-'a']++;
            charcnt[t.charAt(i)-'a']--;

        }
        for(int cnt:charcnt){
            if(cnt!=0){
                return false;
            }
        }
        return true;
    }
}