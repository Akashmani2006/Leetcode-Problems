class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arr[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=1;i<=12;i++)
        {
            arr[i]+=arr[i-1];
        }
        String str1[]=arriveAlice.split("-");
        String str2[]=leaveAlice.split("-");
        String str3[]=arriveBob.split("-");
        String str4[]=leaveBob.split("-");
        int a=arr[Integer.parseInt(str1[0])-1]+Integer.parseInt(str1[1]);
        int b=arr[Integer.parseInt(str2[0])-1]+Integer.parseInt(str2[1]);
        int c=arr[Integer.parseInt(str3[0])-1]+Integer.parseInt(str3[1]);
        int d=arr[Integer.parseInt(str4[0])-1]+Integer.parseInt(str4[1]);
        return Math.max(0,Math.min(b,d)-Math.max(a,c)+1);
    }
}