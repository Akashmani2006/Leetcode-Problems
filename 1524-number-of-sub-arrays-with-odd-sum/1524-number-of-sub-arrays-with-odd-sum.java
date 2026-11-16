class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        for(int i=1;i<n;i++)
        {
            arr[i]+=arr[i-1];
        }
        int oc=0;
        int ev=1;
        int ans=0;
        int mod=1000000007;
        for(int i=0;i<n;i++)
        {
            if((arr[i]&1)==1)
            {
               oc++;
               ans+=ev;

            }
            else
            {
                ev++;
                ans+=oc;
            }
            ans=ans%mod;
        }
        return ans;

    }
}