class Solution {
    public int[] sortByBits(int[] arr){
        int n=arr.length;
        Integer[] res=new Integer[n];
        for(int i=0;i<n;i++){
            res[i]=arr[i];
        }
        Arrays.sort(res, (a,b)->{
            int x=Integer.bitCount(a);
            int y=Integer.bitCount(b);
            if(x!=y){
                return x-y;
            }
            return a-b;
        });
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=res[i];
        }
        return ans;
    }
}