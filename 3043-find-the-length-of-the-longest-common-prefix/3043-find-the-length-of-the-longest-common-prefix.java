class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxlen=0;
        Set<String> prefixset=new HashSet<>();
        //store all prefix of arr1
        for(int num: arr1){
            String s=String.valueOf(num);
            for(int i=1;i<=s.length();i++){
                prefixset.add(s.substring(0,i));
            }
        }
        for(int num:arr2){
            String s=String.valueOf(num);
            for(int i=1;i<=s.length();i++){
                String prefix=s.substring(0,i);
                if(prefixset.contains(prefix)){
                    maxlen=Math.max(maxlen,i);
                }
            }
        }
        return maxlen;
    }
}