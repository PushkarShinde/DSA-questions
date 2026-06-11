class Solution {
    public int findIndex(String s) {
        int n=s.length();
        int[] open=new int[n];
        int[] close=new int[n];
        
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                open[i]=1+(i>0?open[i-1]:0);
            }else{
                open[i]=(i>0?open[i-1]:0);
            }
        }
        if(open[n-1]==0) return n;
        
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==')'){
                close[i]=1+(i<n-1?close[i+1]:0);
            }else{
                close[i]=(i<n-1?close[i+1]:0);
            }
        }
        if(close[0]==0) return 0;
        
        for(int i=1;i<n;i++){
            if(open[i-1]==close[i]){
                return i;
            }
        }
        
        if(s.charAt(0)=='('){
            return 0;
        }else{
            return 1;
        }
    }
}