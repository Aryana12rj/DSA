class Solution {
    public boolean squareIsWhite(String coordinates) {
        int a=(int) coordinates.charAt(0);
        int b=(int) coordinates.charAt(1)-'0';
        if((a%2!=0)&&(b%2!=0)){
            return false;
        }
        if((a%2==0)&&(b%2==0)){
            return false;
        }
        return true;
    }
}