class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        int n=arr.length;
        ArrayList<Integer> res=new ArrayList<>();
        int[] left=new int[n]; 
        int[] right=new int[n]; 
        left[0]=-1;
        int min=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>min){
                left[i]=min;
            }else{
                min=arr[i];
                left[i]=-1;
            }
        }
        
        right[n-1]=-1;
        int max=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]<max){
                right[i]=max;
            }else{
                max=arr[i];
                right[i]=-1;
            }
        }
        
        for(int i=0;i<n;i++){
            int l=left[i];
            int num=arr[i];
            int r=right[i];
            if(l!=-1 && r!=-1 && l<num && num<r){
                res.add(l);
                res.add(num);
                res.add(r);
                return res;
            }
        }
        return res;
    }
}