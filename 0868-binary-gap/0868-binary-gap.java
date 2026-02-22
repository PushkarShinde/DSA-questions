class Solution {
    public int binaryGap(int n) {
        // int[] pos=new int[32];
        //10110
        String bin=Integer.toBinaryString(n);
        int pre=-1, cur=-1;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<bin.length();i++){
            if(pre==-1 && bin.charAt(i)=='1'){
                pre=i;
                cur=i;
                continue;
            }
            if(bin.charAt(i)=='1'){
                cur=i;
                res=Math.max(res, cur-pre);
                pre=cur;
            }
        }
        res=Math.max(res, cur-pre);
        return res;
    }
}