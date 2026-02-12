class Solution {
    public int findPages(int[] arr, int k) {
        int n=arr.length;
        if(k>n) return -1;
        int sum=0;
        int maxPages=Integer.MIN_VALUE;
        for(int i:arr){
            sum+=i;
            maxPages=Math.max(maxPages, i);
        }
        if(k==n) return maxPages;
        int l=maxPages, r=sum;
        while(l<r){
            int mid=l+(r-l)/2;//max number of pages for each kid
            if(possible(arr, k, mid)){//kya at max itne page mai k bacho ko baat sakta hu?
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    private boolean possible(int[] arr, int k, int m){
        int bachhe=1;
        int sum=0;
        for(int i:arr){
            if(sum+i<=m) sum+=i;
            else{
                bachhe++;
                sum=i;
            }
        }
        return bachhe<=k;
    }
}