class Solution {
    // private boolean inc(int arr[],int l,int r)
    // {
    //     int n=arr.length;
    //     for(int i=l;i<r;i++)
    //     {
    //         if(arr[i]>=arr[i+1])
    //         {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // private boolean dec(int arr[],int l,int r)
    // {
    //     int n=arr.length;
    //     for(int i=l;i<r;i++)
    //     {
    //         if(arr[i]<=arr[i+1])
    //         {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public int longestMonotonicSubarray(int[] nums) {
       int ans=Integer.MIN_VALUE;
       int up=1,down=1;
       if(nums.length==1)
       {
        return 1;
       }
       for(int i=1;i<nums.length;i++)
       {
          up=nums[i-1]<nums[i]?up+1:1;
          down=nums[i-1]>nums[i]?down+1:1;
          ans=Math.max(ans,Math.max(up,down));
       }
       return ans; 
        
    }
}