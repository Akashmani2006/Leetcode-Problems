class Solution {
    int removed[];
    int n;
    char str[];
    ArrayList<StringBuilder>ans=new ArrayList<>();
    private void find(int idx)
    { 
        if(idx==n)
        {
            return;
        }
        if(str[idx]!='('&&str[idx]!=')')
        {
            find(idx+1);
            isvalid();
            return;
        }
        isvalid();
        find(idx+1);
        removed[idx]=1;
        isvalid();
        find(idx+1);
        removed[idx]=0;
    }
    private void isvalid()
    {
       boolean flg=true;
       int count=0;
       for(int i=0;i<n;i++)
       {
        if(removed[i]==1)
        {
            continue;
        }
        else if(str[i]=='(')
        {
            count++;
        }
        else if(str[i]==')')
        {
            count--;
        }
        if(count<0)
        {
            flg=false;
            break;
        }
       }
       if(count!=0)
       {
         return;
       }
       if(flg)
       {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(removed[i]==1)
            {
                continue;
            }
            sb.append(str[i]);
            ans.add(sb);
        }
        ans.add(sb);
       }
    }
    public List<String> removeInvalidParentheses(String s) {
        str=s.toCharArray();
        n=str.length;
        removed=new int[n];
        find(0);
        int min=Integer.MIN_VALUE;
        for(int i=0;i<ans.size();i++)
        {
            min=Math.max(min,ans.get(i).length());
        }
        HashSet<String>set=new HashSet<>();
        for(int i=0;i<ans.size();i++)
        {
            if(ans.get(i).length()==min)
            {
                set.add(ans.get(i).toString());
            }
        }
        return new ArrayList<>(set);
    }
}