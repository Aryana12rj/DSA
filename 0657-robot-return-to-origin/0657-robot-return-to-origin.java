class Solution {
    public boolean judgeCircle(String moves) {
        //taking horizontal and vertical direction net displacement should be zero
        int countv=0,counth=0;

        for(int i=0;i<moves.length();i++){
            char ch=moves.charAt(i);
            if(ch=='U')countv++;
            else if(ch=='D')countv--;
            else if(ch=='R')counth++;
            else counth--;
        }
        return countv==0 && counth==0;
    }
}