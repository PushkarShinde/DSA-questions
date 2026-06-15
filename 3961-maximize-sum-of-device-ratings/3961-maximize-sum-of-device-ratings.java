class Solution {
    public long maxRatings(int[][] units) {
        int m=units.length;
        int n=units[0].length;

        long sum=0;
        long sum2=0;
        long secMin=Integer.MAX_VALUE;
        long minVal=Integer.MAX_VALUE;
        for(int[] device:units){
            long first=Integer.MAX_VALUE;
            long second=Integer.MAX_VALUE;
            for(int j:device){
                if(j<first){
                    second=first;
                    first=j;
                }else if(j<second){
                    second=j;
                }
            }
            if(device.length==1) second=0;

            sum+=first;
            sum2+=second;
            minVal=Math.min(first, minVal);
            secMin=Math.min(second, secMin);
        }
        return Math.max(sum, (long)minVal+sum2-secMin);
    }
}