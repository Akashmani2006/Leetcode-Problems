class Solution {
    public int sumCounts(List<Integer> nums) {
      int n=nums.size();
      HashSet<Integer>set=new HashSet<>();
      int ans=0;
      for(int i=0;i<n;i++)
      {
          for(int j=0;j<n;j++)
          {
              for(int k=i;k<=j;k++)
              {
                set.add(nums.get(k));
              }
              ans+=(set.size()*set.size());
              set=new HashSet<>();
          }
      }
     return ans;
    }
}