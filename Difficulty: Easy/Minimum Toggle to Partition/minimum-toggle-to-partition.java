class Solution {
    int minToggle(int[] arr) {
        int n=arr.length;
        int[] one=new int[n];
        int[] zero=new int[n];
        
        for(int i=0;i<n;i++){
            int num=arr[i];
            if(num==0) zero[i]=(i==0?0:zero[i-1])+1;
            else zero[i]=(i==0?0:zero[i-1]);
        }
        for(int i=0;i<n;i++){
            int num=arr[i];
            if(num==1) one[i]=(i==0?0:one[i-1])+1;
            else one[i]=(i==0?0:one[i-1]);
        }
        
        int res=zero[n-1];
        for(int i=0;i<n;i++){
            int left=one[i];
            int right=zero[n-1]-zero[i];
            res=Math.min(left+right, res);
        }
        return res;
    }
}