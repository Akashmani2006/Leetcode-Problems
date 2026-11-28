class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        int min=Integer.MAX_VALUE;
        int dp[]=new int[budget+1];
        for(int i=0;i<n;i++)
        { 
            int cost=items[i][1];
            min=Math.min(min,cost);
            int factor=items[i][0];
            int pr=1;
            for(int j=0;j<n;j++)
            {
                if(j!=i&&items[j][0]%factor==0)
                {
                    pr++;
                }
            }
            for(int b=budget;b>=cost;b--)
            {
                dp[b]=Math.max(dp[b],dp[b-cost]+pr);
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<=budget;i++)
        {
            ans=Math.max(ans,dp[i]+(budget-i)/min);
        }
        return ans;
    }
}