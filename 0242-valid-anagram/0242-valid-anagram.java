class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        //count freq of char in string s
        for(char x:s.toCharArray()){
            map.put(x,map.getOrDefault(x,0)+1);

        }
        //decrement the freq of character in string t
        for(char y:t.toCharArray()){
            map.put(y,map.getOrDefault(y,0)-1);
        }
        for(int count:map.values()){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
}