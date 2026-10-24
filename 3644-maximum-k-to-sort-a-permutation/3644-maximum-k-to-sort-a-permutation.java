class Solution {
    public int sortPermutation(int[] nums) {
       boolean found=false;
       int ans=0;
       for(int i=0;i<nums.length;i++)
       {
        if(nums[i]!=i)
        {
            if(!found)
            {
                ans=nums[i];
                found=true;
            }
            else
            {
                ans&=nums[i];
            }
        }
       } 
       return ans;
    }
}