class Solution {
    public int passwordStrength(String password) {
        boolean[] seen = new boolean[128];
        char[] cha = password.toCharArray();
        int sum = 0;
        for(char ch : cha){
            if(!seen[ch]){
                sum += points(ch);
                seen[ch] = true;
            }
        }
        return sum;
    }
    static int points(char a){
        if( Character.isLowerCase(a)){
            return 1;
        }
        if(Character.isUpperCase(a)){
            return 2;
        }
        if(Character.isDigit(a)){
            return 3;
        }
        if("!@#$".contains(String.valueOf(a))) {
            return 5;
        }
        return 0;
    }
}