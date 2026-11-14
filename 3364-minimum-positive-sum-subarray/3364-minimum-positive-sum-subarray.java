class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int prefix[]=new int[nums.size()+1];
        int ans=Integer.MAX_VALUE;
        boolean found=true;
        for(int i=0;i<n;i++)
        {
         prefix[i+1]=prefix[i]+nums.get(i);
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=i;j<=n;j++)
            {
                int val=prefix[j]-prefix[i-1];
                  int len=(j-i+1);
                if(val>0&&l<=len&&len<=r)
                {
                    ans=Math.min(ans,val);
                    found=false;
                }
            }
        }
        if(found)
        {
            return -1;
        }
        return ans;
    }
}