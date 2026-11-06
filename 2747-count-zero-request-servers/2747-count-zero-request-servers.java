class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m=logs.length;
        int q=queries.length;
        int sq[][]=new int[q][2];
        for(int i=0;i<q;i++)
        {
            sq[i]=new int[]{queries[i],i};
        }
        Arrays.sort(sq,(a,b)->a[0]-b[0]);
        Arrays.sort(logs,(a,b)->a[1]-b[1]);
        int ans[]=new int[q];
        int freq[]=new int[n+1];
        int l=0;
        int r=0;
        int actserver=0;
        for(int i[]:sq)
        {
            int idx=i[1];
            int st=i[0]-x;
            int end=i[0];
            while(r<m&&logs[r][1]<=end)
            {
                int server=logs[r][0];
                if(freq[server]==0)
                {
                    actserver++;
                }
                r++;
                freq[server]++;
            }
            while(l<r&&logs[l][1]<st)
            {
                int server=logs[l][0];
                freq[server]--;
                if(freq[server]==0)
                {
                    actserver--;
                }
                l++;
            }
            ans[idx]=n-actserver;

        }
        return ans;

    }
}