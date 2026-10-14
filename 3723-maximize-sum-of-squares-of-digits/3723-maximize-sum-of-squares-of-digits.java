class Solution {
    public String maxSumOfSquares(int num, int sum) {
      StringBuilder sb=new StringBuilder();
      for(int i=0;i<num;i++)
      {
        for(int dig=9;dig>=0;dig--)
        {
            if(dig<=sum)
            {
                sb.append(dig);
                sum-=dig;
                break;
            }
        }
      }
      if(sum!=0)
      {
        return "";
      }
      return sb.toString();
    }

}