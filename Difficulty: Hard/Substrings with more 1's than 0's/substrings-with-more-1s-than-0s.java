class Solution {
    public int countSubstring(String s) {
        int n=s.length();
        int[] bit=new int[2*n+2];
        int total=0;
        int cur=0;
        int offset=n+1;
        
        update(bit, 0+offset, 1);//initial empty pre sum 
        
        for(int i=0;i<n;i++){
            cur+=(s.charAt(i)=='1')?1:-1;
            
            total+=query(bit, cur-1+offset);// iske pehle means isse chote kitne pre sum hai
            
            update(bit, cur+offset, 1);//adding the current pre sum to our fenwick tree
        }
        
        return total;
    }
    
    private void update(int[] a, int ind, int val){
        while(ind<a.length){
            a[ind]+=val;
            ind+=(ind & -ind);
        }
    }
    
    private int query(int[] a, int x){
        int res=0;
        while(x>0){
            res+=a[x];
            x-=(x & -x);
        }
        return res;
    }
}