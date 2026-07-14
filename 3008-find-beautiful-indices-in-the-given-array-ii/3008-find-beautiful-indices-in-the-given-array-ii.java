class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int n=s.length();
        int p=a.length();
        int q=b.length();
        List<Integer> res=new ArrayList<>();

        int[] lps=create(a);

        List<Integer> A=new ArrayList<>();
        List<Integer> B=new ArrayList<>();
        int i=0, j=0;
        while(i<n && j<p){
            if(s.charAt(i)==a.charAt(j)){
                i++; j++;
            }

            if(j==p){
                A.add(i-j);
                j=lps[j-1];
            }else if(i<n && s.charAt(i)!=a.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
        
        lps=create(b);
        i=0; j=0;
        while(i<n && j<q){
            if(s.charAt(i)==b.charAt(j)){
                i++; j++;
            }

            if(j==q){
                B.add(i-j);
                j=lps[j-1];
            }else if(i<n && s.charAt(i)!=b.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }

        i=0; j=0;
        while(i<A.size() && j<B.size()){
            int x=A.get(i);
            int y=B.get(j);
            if(Math.abs(x-y)<=k){
                res.add(x);
                i++;
            }else{
                if(x<y){
                    i++;
                }else{
                    j++;
                }
            }
        }

        return res;
    }

    private int[] create(String s){
        int n=s.length();
        int[] lps=new int[n];

        lps[0]=0;

        int i=1, len=0;
        while(i<n){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }

        return lps;
    }
}