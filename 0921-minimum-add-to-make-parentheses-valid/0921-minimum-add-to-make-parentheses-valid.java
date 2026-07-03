class Solution {
    public int minAddToMakeValid(String s) {
        //intialize two pointers for unmatched open and unmatched close parennthesis
        int open_need=0;
        int close_need=0;

        for(char ch: s.toCharArray()){
            if(ch=='('){
                open_need++;
            }else{
                if(open_need > 0){
                    open_need--;
                }else{
                    close_need++;
                }
            }

        }
        return open_need+close_need;
    }
}