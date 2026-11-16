class Solution {
    private int find(String str)
    {
        int sum=0;
        for(int i=0;i<str.length();i++)
        {
            sum+=str.charAt(i)-'0';
        }
        return sum;
    }
    public String digitSum(String s, int k) {
        while(s.length()>k)
        {
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i+=k)
            {
                 int val=find(s.substring(i,Math.min(i+k,s.length())));
                 sb.append(Integer.toString(val));
            }
            s=sb.toString();
        }
        return s;
    }
}