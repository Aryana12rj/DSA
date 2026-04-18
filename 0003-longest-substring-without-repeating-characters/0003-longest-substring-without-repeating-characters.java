class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int longest=0;
        for(int i=0;i<s.length();i++){
            Set<Character> set=new HashSet<>();
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                if(set.contains(ch)){
                    break;
                }
                set.add(ch);
                longest=Math.max(longest,j-i+1);
            }
        }
        return longest;

    }
}