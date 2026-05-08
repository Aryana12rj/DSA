class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int maxlength=0;
        Map<Character,Integer> chrmap=new HashMap<>();
        int left=0;
        for(int right=0;right<n;right++){
            if(!chrmap.containsKey(s.charAt(right))||chrmap.get(s.charAt(right))<left){
                chrmap.put(s.charAt(right),right);
                maxlength=Math.max(maxlength,right-left+1);
            }else{
                left=chrmap.get(s.charAt(right))+1;
                chrmap.put(s.charAt(right),right);
            }
        }
        return maxlength;
    }
}