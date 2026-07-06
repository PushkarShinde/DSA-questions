class Solution {
    public long getSum(int[] nums) {
        int n=nums.length;
        
        int[] trans=new int[2*n+1];
        for(int i=0;i<n;i++){
            trans[2*i]=-1;
            trans[2*i+1]=nums[i];
        }
        trans[2*n]=-1;

        int m=trans.length;
        int[] rad=new int[m];
        int c=0;//center of the palindrome that extends furthest to the right
        int r=0;//right boundary of that palindrome

        for(int i=0;i<m;i++){
            int mirror=2*c-i;
            if(r>i){
                rad[i]=Math.min(r-i, rad[mirror]);
            }else{
                rad[i]=0;
            }

            while(i-1-rad[i]>=0 && i+1+rad[i]<m && trans[i-1-rad[i]]==trans[i+1+rad[i]]){
                rad[i]++;
            }

            if(i+rad[i]>r){
                c=i;
                r=i+rad[i];
            }
        }

        long[] pre=new long[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+(long)nums[i];
        }

        long sum=0;
        for(int i=0;i<m;i++){
            int len=rad[i];
            if(len>0){
                int start=(i-len)/2;
                int end=start+len-1;
                long cur=pre[end+1]-pre[start];
                sum=Math.max(sum, cur);
            }
        }

        return sum;
    }
}