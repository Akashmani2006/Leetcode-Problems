class Solution {
    public int sum(int n)
    {
        int sum=0;
        while(n>0)
        {
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int res[][]=new int[n][2];
        for(int i=0;i<n;i++)
        {
            res[i]=new int[]{nums[i],sum(nums[i])};
        }
        Arrays.sort(res,(a,b)->
        {
            if(a[1]!=b[1])
        {
            return a[1]-b[1];
        }
        else
        {
            return a[0]-b[0];
        }});
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],i);
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(res[i][0]!=nums[i])
            {
                count++;
                int idx=map.get(res[i][0]);
                int temp=nums[i];
                nums[idx]=temp;
                nums[i]=res[i][0];
                map.put(nums[i],i);
                map.put(nums[idx],idx);
            }
        }
        return count;
    }
}