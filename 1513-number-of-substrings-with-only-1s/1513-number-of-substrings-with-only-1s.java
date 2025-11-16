class Solution {
    private int mod=(int)1e9+7;
    public int numSub(String s) {
        long res=0;
        int count=0;
        s=s+'0';
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }else{
                if(count>0){
                    long contribution=((long)count*(count+1))/2;
                    res=(res+contribution)%mod;
                    count=0;
                }
            }
        }
        return (int)res;
    }
}