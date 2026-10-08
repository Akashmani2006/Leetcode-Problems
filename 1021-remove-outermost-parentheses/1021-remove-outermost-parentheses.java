class Solution {
    public String removeOuterParentheses(String s) {
     Stack<Integer>st=new Stack<>();
     int count=0;
     StringBuilder sb=new StringBuilder();
     for(int i=0;i<s.length();i++)
     {
        if(s.charAt(i)=='(')
        {
            count++;
            st.push(i);
        }
        else
        {
            count--;
            if(count==0)
            {
                sb.append(s.substring(st.pop()+1,i));
            }
            else
            {
                st.pop();
            }
        }
     }
     return sb.toString();
    }
}