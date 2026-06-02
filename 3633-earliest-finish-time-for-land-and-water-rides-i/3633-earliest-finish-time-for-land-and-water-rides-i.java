class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minA=Integer.MAX_VALUE;
        int landFirst=Integer.MAX_VALUE;
        int l=landStartTime.length;
        int w=waterStartTime.length;
        for(int i=0;i<l;i++){
            minA=Math.min(minA, landStartTime[i]+landDuration[i]);
        }
        int minC=Integer.MAX_VALUE;
        for(int i=0;i<w;i++){
            landFirst=Math.min(landFirst, Math.max(waterStartTime[i], minA)+waterDuration[i]);
            minC=Math.min(minC, waterStartTime[i]+waterDuration[i]);
        }
        int waterFirst=Integer.MAX_VALUE;
        for(int i=0;i<l;i++){
            waterFirst=Math.min(waterFirst, Math.max(landStartTime[i], minC)+landDuration[i]);
        }

        return Math.min(landFirst,waterFirst);
    }
}