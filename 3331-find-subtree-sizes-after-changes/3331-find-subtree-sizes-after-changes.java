class Solution {
    int arr[]=new int[26];
    {
    Arrays.fill(arr,-1);
    }
    int update[];
    HashMap<Integer,List<Integer>>map=new HashMap<>();
    int ans[];
    char str[];
    private void find(int node)
    {
        update[node]=arr[str[node]-'a'];
        int prev=arr[str[node]-'a'];
        arr[str[node]-'a']=node;
        for(int newnode:map.get(node))
        {
            find(newnode);
        }
        arr[str[node]-'a']=prev;
        return;
    }
    private int sum(int node)
    {
        int total=1;
        if(map.get(node).size()==0)
        {
            ans[node]=1;
            return 1;
        }
        for(int newnode:map.get(node))
        {
            total+=sum(newnode);
        }
        ans[node]=total;
        return ans[node];
        
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;
        update=new int[n];
        str=s.toCharArray();
        for(int i=0;i<n;i++)
        {
            map.put(i,new ArrayList<>());
        }
        for(int i=1;i<n;i++)
        {
            map.get(parent[i]).add(i);
        }
        find(0);
        for(int i=0;i<n;i++)
        {
            if(update[i]!=-1)
            {
                parent[i]=update[i];
            }
        }
        map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(i,new ArrayList<>());
        }
        for(int i=1;i<n;i++)
        {
            map.get(parent[i]).add(i);
        }
        ans=new int[n];
        sum(0);
        return ans;
        
    }
}