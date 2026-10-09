class Solution {
    public int minInsertions(String s) {
        Stack<Integer>st=new Stack<>();
        int count=0;
       for(int i=0;i<s.length();i++)
       {
        if(s.charAt(i)=='(')
        {
            if(!st.isEmpty()&&st.peek()==1)
            {
                count+=st.pop();
            }
            st.push(2);
        }
        else
        {
            if(st.isEmpty())
            {
                count++;
                st.push(2);
            }
            st.push(st.pop()-1);
            if(st.peek()==0)
            {
                st.pop();
            }
        }
       }
        while(!st.isEmpty())
       {
          count+=st.pop();
       } 
       return count;
    }
}