class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        int minamout=Math.min(cost1+cost2,costBoth);
        int both_purchase=Math.min(need1,need2);
        long ans=(long)minamout*both_purchase;
        if(need1-both_purchase>0)
        {
            ans+=(long)(need1-both_purchase)*Math.min(cost1,costBoth);
        }
        if(need2-both_purchase>0)
        {
            ans+=(long)(need2-both_purchase)*Math.min(cost2,costBoth);
        }
        return ans;
    }
}