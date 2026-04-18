class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch : s.toCharArray()){
            if(st.isEmpty()||ch=='('||ch=='{'||ch=='['){
                st.push(ch);
                continue;
            }
            if(ch==')'){
                if(st.peek()=='('){
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch=='}'){
                if(st.peek()=='{'){
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch==']'){
                if(st.peek()=='['){
                    st.pop();
                }else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}