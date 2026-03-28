class Solution {
    public String orderlyQueue(String s, int k) {
        if(k==1){
            String beststr =s;
            for(int i=1;i<s.length();i++){
                String rotate=s.substring(i)+s.substring(0,i);
                if(rotate.compareTo(beststr)<0){
                    beststr=rotate;
                }
            }
            return beststr;
        }
        else{
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}