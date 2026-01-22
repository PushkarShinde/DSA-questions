class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> a=new ArrayList<>();
        for(int i:nums) a.add(i);
        int res=0;
        while(true){
            if(inc(a)) break;
            int m=a.size();
            int minInd=0;
            int minSum=Integer.MAX_VALUE;
            for(int i=0;i<m-1;i++){
                int sum=a.get(i)+a.get(i+1);
                if(minSum>sum){
                    minSum=sum;
                    minInd=i;
                }
            }
            a.set(minInd,minSum);
            a.remove(minInd+1);
            res++;
        }
        return res;
    }
    private boolean inc(List<Integer> a){
        for(int i=0;i<a.size()-1;i++){
            if(a.get(i)>a.get(i+1)) return false;
        }
        return true;
    }
}