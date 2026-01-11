class Solution {
    public long countPairs(String[] words) {
        Map<String,Integer> f=new HashMap<>();
        for(String word:words){
            String g=getsign(word);
            f.put(g,f.getOrDefault(g,0)+1);
        }
        long c=0;
        for(int fr:f.values()){
            c+=(long)fr*(fr-1)/2;
        }
        return c;
    }
    private String getsign(String word){
        int b=word.charAt(0)-'a';
        StringBuilder s=new StringBuilder(word.length());
        for(int i=0;i<word.length();i++){
            int d=(word.charAt(i)-'a'-b+26)%26;
            s.append((char)('a'+d));
        }
        return s.toString();
    }
}