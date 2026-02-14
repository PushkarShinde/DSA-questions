class Solution {
    public int minTime(int[] arr, int k) {
        int n=arr.length;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            sum+=i;
            max=Math.max(max, i);
        }
        int l=max, r=sum;
        while(l<r){
            int mid=l+(r-l)/2;
            if(possible(arr, k, mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    private boolean possible(int[] a, int k, int time){
        int parts=1;
        int seg=0;
        for(int i:a){
            if(seg+i<=time){
                seg+=i;
            }else{
                parts++;
                seg=i;
            }
        }
        return parts<=k;
    }
}
