class Solution {
    public int maxSubsetXOR(int[] arr) {
        int n=arr.length;
        
        int[] bits=new int[32];
        for(int x:arr){
            for(int i=31;i>=0;i--){
                if((x & (1<<i))!=0){
                    if(bits[i]==0){
                        bits[i]=x;
                        break;
                    }else{
                        x^=bits[i];
                    }
                }
            }
        }
        
        int maxXor=0;
        for(int i=31;i>=0;i--){
            if((maxXor^bits[i])>maxXor) maxXor^=bits[i];
        }
        return maxXor;
    }
}