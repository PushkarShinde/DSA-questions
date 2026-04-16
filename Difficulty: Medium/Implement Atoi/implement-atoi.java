class Solution {
    public int myAtoi(String s) {
        int max=Integer.MAX_VALUE;
        long res=0;
        s=s.trim();
        boolean neg=false;
        for(char c:s.toCharArray()){
            if(c=='-'){
                neg=true;
                continue;
            }
            if(c>'9' || c<'0') continue;
            long num=c-'0';
            res=res*10+num;
            if(res>max){
                if(!neg) res=max;
                else res=Integer.MIN_VALUE;
                break;
            }
        }
        if(neg){
            res=-1*res;
        }
        return (int)res;
    }
}