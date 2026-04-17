class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map=new HahMap<>();
        //count freq of char in string s
        for(char x:s.charArray()){
            map.put(x,mp.getOrDefault(x,0)+1);

        }
        //decrement the freq of character in string t
        for(char y:t.charArray()){
            mp.put(y,mp.getOrDefault(y,0)-1);
        }
        for(int count:mp.values()){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
}