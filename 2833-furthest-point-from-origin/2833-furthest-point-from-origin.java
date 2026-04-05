class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int res=0,dist=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L')res--;
            if(moves.charAt(i)=='R')res++;
            if(moves.charAt(i)=='_')dist++;

        }
        return Math.abs(res)+dist;
    }
}