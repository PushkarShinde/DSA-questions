class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();

        int[] preone=new int[n];
        preone[0]=(s.charAt(0)=='0'?0:1);
        for(int i=1;i<n;i++) preone[i]=s.charAt(i)=='1'?preone[i-1]+1:preone[i-1];

        int res=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int one=preone[j]-((i>0)?preone[i-1]:0);
                int zero=j-i+1-one;
                int square=zero*zero;

                if(square>one){
                    int k=square-one;
                    j+=k-1;
                }else{
                    int k=(int)Math.sqrt(one)-zero;
                    int next=j+k;
                    if(next>=n){
                        k=n-1-j;
                    }
                    res+=k+1;
                    j=next;
                }
            }
        }

        return res;
    }
}