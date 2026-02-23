class Solution {
    public boolean hasAllCodes(String s, int k) {
        //int total = (int)Math.pow(2,k);
        int total = 1<<k; 
        if(s.length()-k+1<total) return false;

        Set<String> set=new HashSet();
        

        for(int i=k-1; i<s.length(); i++){
            String s1=s.substring(i-k+1,i+1);

            if(!set.contains(s1)){
                set.add(s1);
                if(set.size()==total)  return true;
            }        
        }
       

        return false;
    }
}