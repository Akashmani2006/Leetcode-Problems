class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(Math.abs(nums[i]));
        }
        Collections.sort(list);
        int pos=n-1;
        int neg=0;
        long ans=0;
        while(neg<pos)
        {
           long posval=list.get(pos)*list.get(pos);
           long negval=list.get(neg)*list.get(neg);
           ans+=posval;
           ans-=negval;
           pos--;
           neg++;
        }
        if(neg==pos)
        {
            ans+=((long)list.get(pos)*list.get(pos));
        }
        return ans;
    }
}