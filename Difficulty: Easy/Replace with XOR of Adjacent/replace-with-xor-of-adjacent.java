class Solution {
    public void replaceElements(int[] arr) {
        int n=arr.length;
        int[] res=new int[n];
        
        res[0]=arr[1]^arr[0];
        
        for(int i=1;i<n-1;i++){
            int pre=arr[i-1];
            int post=arr[i+1];
            res[i]=pre^post;
        }
        
        res[n-1]=arr[n-2]^arr[n-1];
        
        for(int i=0;i<n;i++){
            arr[i]=res[i];
        }
        
    }
}