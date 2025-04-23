class Solution {
    private int digSum(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        // HashMap<Integer> map=new HashMap<>();
        int[] map=new int[37];
        int maxVal=0;
        for(int i=1;i<=n;i++){
            int j=digSum(i);
            map[j]++;
            maxVal=Math.max(maxVal, map[j]);
        }
        int res=0;
        for(int i:map){
            if(i==maxVal) res++;
        }
        return res;
    }
}