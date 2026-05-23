class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> freq=new HashMap<>();
        for(char c:t.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        for(char c:s.toCharArray()){
            freq.put(c,freq.get(c)-1);
        }

        for(Map.Entry<Character,Integer> entry:freq.entrySet()){
            if(entry.getValue()!=0){
                return entry.getKey();
            }
        }
        return ' ';
    }
}