class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        Map<Character,Integer> mp=new HashMap<>();
        int longest=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            mp.put(ch,mp.getOrDefault(ch,0)+1);

            while(mp.get(ch)>1){
                char leftchar=s.charAt(left);
                mp.put(leftchar,mp.get(leftchar)-1);
                left++;
            }
            longest=Math.max(longest,right-left+1);
        }
        return longest;

    }
}