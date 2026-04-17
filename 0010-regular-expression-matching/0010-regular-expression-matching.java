class Solution {
    public boolean solve(String s,String p){
        if(p.length()==0){
            if(s.length()==0){
                return true;
            }
            return false;
        }
        boolean first_catch_match=false;
        if(s.length()> 0 &&(p.charAt(0)==s.charAt(0)||p.charAt(0)=='.')){
            first_catch_match=true;
        }
        if(p.length()>=2 &&p.charAt(1)=='*'){
            boolean nottake=solve(s,p.substring(2));
            boolean take=first_catch_match && solve(s.substring(1),p);
            return nottake || take;
        }else{
            return first_catch_match && solve(s.substring(1),p.substring(1));
        }

    }
    public boolean isMatch(String s, String p) {
        return solve(s,p);
    }
}