class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int[] no=new int[n];
        int[] yes=new int[n];
        int count=0;
        for(int j=0;j<n;j++){
            if(customers.charAt(j)=='N'){
                count++;
                no[j]=count;
                continue;
            }
            no[j]=count;
        }
        count=0;
        for(int j=n-1;j>=0;j--){
            if(customers.charAt(j)=='Y'){
                count++;
                yes[j]=count;
                continue;
            }
            yes[j]=count;
        }
        int penalty=Integer.MAX_VALUE;
        int res=0;
        for(int j=0;j<=n;j++){
            int nos=(j!=0)?no[j-1]:0;
            int yess=(j!=n)?yes[j]:0;
            if(penalty>nos+yess){
                penalty=nos+yess;
                res=j;
            }
        }
        return res;
    }
}