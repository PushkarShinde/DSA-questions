class Solution {
    public int[] sumZero(int n) {
        int[] res=new int[n];
        int i=0;
        int ind=1;
        if(n%2!=0){
            res[0]=0;
            i=1;
        } 
        while(i<n){
            res[i]=ind;
            res[i+1]=ind*(-1);
            i+=2;
            ind++;
        }
        return res;
    }
}