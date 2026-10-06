class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Node>st=new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                st.push(new Node(ch));
            }
            else
            {
               Node curr=st.pop();
               if(st.isEmpty())
               {
                    ans+=(int)(curr.val*2);
               }
               else
               {
                if(st.peek().val==0.5)
                st.peek().val=curr.val*2;
                else
                st.peek().val+=curr.val*2;
               } 
            }
        }
        return ans;
    }
}
class Node
{
    double val;
    char ch;
    Node(char ch)
    {
        this.val=0.5;
        this.ch=ch;
    }
}