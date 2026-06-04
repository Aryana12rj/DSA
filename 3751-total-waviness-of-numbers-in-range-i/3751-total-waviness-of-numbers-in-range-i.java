class Solution {
    public int totalWaviness(int num1, int num2) {
        int total=0;
        for(int i=num1;i<=num2;i++){
            total +=getwaviness(i);
            
        }
        return total;
        
    }
    private int getwaviness(int num){
        String s= String.valueOf(num);
        int count=0;
        int len=s.length();
        if(len<3) return 0;
        for(int i=1;i<len-1;i++){
            int prev=s.charAt(i-1)-'0';
            int curr=s.charAt(i)-'0';
            int next=s.charAt(i+1)-'0';

            if((curr>prev && curr>next)||(curr<prev && curr<next)){
                count++;
            }
            
        }
        return count;
    }
}