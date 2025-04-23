class Solution {
    public int countLargestGroup(int n) {
        // HashMap<Integer> map=new HashMap<>();
        int[] map=new int[37];
        int maxVal=0;
        for(int i=1;i<=n;i++){
            int a=i%10;
            int b=(i/10)%10;
            int c=(i/100)%10;
            int d=(i/1000)%10;
            int j=a+b+c+d;
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