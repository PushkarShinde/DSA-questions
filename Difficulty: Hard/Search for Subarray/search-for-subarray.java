class Solution {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> res=new ArrayList<>();
        int n=a.length;
        int m=b.length;
        if(n<m) return res;
        /*
        BRUTE FOPCE O(n*m)
        List<Integer> first=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(a[i]==b[0]) first.add(i);
        }
        for(int k:first){
            if(k+m-1>=n) continue;
            boolean found=true;
            for(int i=0;i<m;i++){
                if(a[k+i]!=b[i]){
                    found=false;
                    break;
                }
            }
            if(found) res.add(k);
        }
        */
        
        //KMP TC - O(N+M)
        int[] lsp=buildLSP(b);
        int i=0, j=0;
        while(i<n){
            if(a[i]==b[j]){
                i++; j++;
            }
            if(j==m){
                res.add(i-j);
                j=lsp[j-1];
            }else if(i<n && a[i]!=b[j]){
                if(j!=0){
                    j=lsp[j-1];
                }else{
                    i++;
                }
            }
        }
        return res;
    }
    private int[] buildLSP(int[] b){
        int m=b.length;
        int[] lsp=new int[m];
        int len=0, i=1;
        while(i<m){
            if(b[i]==b[len]){
                lsp[i]=len+1;
                len++;
                i++;
            }else if(len!=0){
                len=lsp[len-1];
            }else{
                lsp[i]=0;
                i++;
            }
        }
        return lsp;
    }
}