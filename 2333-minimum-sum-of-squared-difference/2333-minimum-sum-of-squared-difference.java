class Solution {
    int arr[];
    int n;
    private long find(int mid)
    {
       long need=0;
       for(int i=0;i<n;i++)
       {
          need+=Math.max(0,arr[i]-mid);
       }
       return need;
    }
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        n=nums1.length;
        arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=Math.abs(nums1[i]-nums2[i]);
        }
        Arrays.sort(arr);
        int l=0;
        int r=arr[n-1];
        while(l<r)
        {
            int mid=l+(r-l)/2;
            if(find(mid)<=k1+k2)
            {
               r=mid;
            }
            else
            {
                l=mid+1;
            }
        }
        long rem=k1+k2-find(l);
        for(int i=0;i<n;i++)
        {
            if(arr[i]>l)
            {
                arr[i]=l;
            }
        }
        if(l==0)
        {
            return 0;
        }
        for(int i=1;i<=rem;i++)
        {
            arr[n-i]--;
        }
        long ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=((long)(arr[i])*arr[i]);
        }
        return ans;
    }
    }