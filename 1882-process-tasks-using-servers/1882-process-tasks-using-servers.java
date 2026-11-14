class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n=servers.length;
        int m=tasks.length;
        PriorityQueue<Node>free=new PriorityQueue<>((a,b)->{
            if(a.w!=b.w)
            {
                return a.w-b.w;
            }
            else
            {
                return a.id-b.id;
            }
        });
        PriorityQueue<Node>busy=new PriorityQueue<>((a,b)->{
            if(a.endtime!=b.endtime)
            {
                return a.endtime-b.endtime;
            }
            else
            {
                if(a.w!=b.w)
                {
                    return a.w-b.w;
                }
                else
                {
                    return a.id-b.id;
                }
            }
        });
        for(int i=0;i<n;i++)
        {
            free.offer(new Node(i,servers[i],-1));
        }
        int ans[]=new int[m];
        for(int i=0;i<m;i++)
        {
            while(!busy.isEmpty()&&busy.peek().endtime<=i)
            {
                free.offer(busy.poll());
            }
            if(!free.isEmpty())
            {
                Node curr=free.poll();
                ans[i]=curr.id;
                curr.endtime=i+tasks[i];
                busy.offer(curr);
            }
            else
            {
                Node curr=busy.poll();
                ans[i]=curr.id;
                curr.endtime+=tasks[i];
                busy.offer(curr);
            }
        }
        return ans;
    }
}
class Node
{
    int id;
    int w;
    int endtime;
    Node(int id,int w,int endtime)
    {
        this.id=id;
        this.w=w;
        this.endtime=endtime;
    }
}