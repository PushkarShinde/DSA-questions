class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        int[] peak=new int[n];
        int[] valley=new int[n];
        for(int i=1;i<n-1;i++){
            if(arr[i-1]<=arr[i] && arr[i]>=arr[i+1]){
                peak[i]=peak[i-1]+1;
            }else{
                peak[i]=peak[i-1];
            }
            
            if(arr[i-1]>arr[i] && arr[i]<arr[i+1]){
                valley[i]=valley[i-1]+1;
            }else{
                valley[i]=valley[i-1];
            }
        }
    
        ArrayList<Boolean> res=new ArrayList<>();
        for(int[] q:queries){
            int l=q[0], r=q[1];
            if (r - l < 2) {
                res.add(true);
                continue;
            }
            if(((r>0?peak[r-1]:0)-peak[l]<=1) && 
                ((r>0?valley[r-1]:0)-valley[l]==0)){
                res.add(true);
                continue;
            }    
            res.add(false);
        }
        
        return res;
    }
}