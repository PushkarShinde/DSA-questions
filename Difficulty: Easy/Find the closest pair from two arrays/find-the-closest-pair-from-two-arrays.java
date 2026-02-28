class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        int n=arr1.length;
        int m=arr2.length;
        ArrayList<Integer> res=new ArrayList<>();
        int dif=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int num=arr1[i];
            int l=0, r=m-1;
            int ans=0;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(arr2[mid]+num<=x){
                    ans=mid;
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
            int sum=num+arr2[ans];
            if(Math.abs(x-sum)<dif){
                res.clear();
                res.add(num);
                res.add(arr2[ans]);
                dif=Math.abs(x-sum);
            }
            if(ans+1<m) sum=num+arr2[ans+1];
            if(Math.abs(x-sum)<dif){
                res.clear();
                res.add(num);
                res.add(arr2[ans+1]);
                dif=Math.abs(x-sum);
            }
            if(ans-1>=0) sum=num+arr2[ans-1];
            if(Math.abs(x-sum)<dif){
                res.clear();
                res.add(num);
                res.add(arr2[ans-1]);
                dif=Math.abs(x-sum);
            }
        }
        return res;
    }
}