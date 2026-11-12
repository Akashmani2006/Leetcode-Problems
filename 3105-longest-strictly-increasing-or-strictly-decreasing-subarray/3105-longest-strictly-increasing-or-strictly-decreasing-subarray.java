class Solution {
    private boolean inc(int arr[],int l,int r)
    {
        int n=arr.length;
        for(int i=l;i<r;i++)
        {
            if(arr[i]>=arr[i+1])
            {
                return false;
            }
        }
        return true;
    }
    private boolean dec(int arr[],int l,int r)
    {
        int n=arr.length;
        for(int i=l;i<r;i++)
        {
            if(arr[i]<=arr[i+1])
            {
                return false;
            }
        }
        return true;
    }

    public int longestMonotonicSubarray(int[] nums) {
        int ans=Integer.MIN_VALUE;
        for(int l=0;l<nums.length;l++)
        {
            for(int r=l;r<nums.length;r++)
            {
                if(inc(nums,l,r)||dec(nums,l,r))
                {
                    ans=Math.max(r-l+1,ans);
                }
            }
        }
        return ans;
        
    }
}