class Solution {
    int maxOnes(int[] arr){
        int n=arr.length;
        int total=0;
        for(int i:arr){
            if(i==1) total++;
        }
        
        if(total==n) return n;
        
        int gain=Integer.MIN_VALUE;
        int curGain=0;
        
        for(int i:arr){
            int val=(i==0)?1:-1;
            curGain=Math.max(val, curGain+val);
            gain=Math.max(gain, curGain);
        }
        
        return total+gain;
    }
};