class Solution {
    private int[] zfun(char[] s){
        int n=s.length;
        int[] z=new int[n];
        z[0]=n;

        int l=0, r=0;
        for(int i=1;i<n;i++){
            if(i<r){
                z[i]=Math.min(z[i-l], r-i);
            }

            while(i+z[i]<n && s[z[i]]==s[i+z[i]]){
                z[i]++;
            }

            if(i+z[i]>r){
                l=i;
                r=i+z[i];
            }
        }
        return z;
    }

    public int minStartingIndex(String s, String pattern) {
        int n=s.length();
        int m=pattern.length();

        char[] left=new char[m+1+n];
        for(int i=0;i<m;i++){
            left[i]=pattern.charAt(i);
        }
        left[m]='#';
        for(int i=0;i<n;i++){
            left[m+1+i]=s.charAt(i);
        }

        int[] zleft=zfun(left);
        int[] leftMatch=new int[n];
        for(int i=0; i <= n-m; i++){
            leftMatch[i] = Math.min(zleft[m + 1 + i], m);
        }
        
        
        String rp = new StringBuilder(pattern).reverse().toString();
        String rs = new StringBuilder(s).reverse().toString();

        char[] right = new char[m + 1 + n];
        for (int i = 0; i < m; i++) {
            right[i] = rp.charAt(i);
        }
        right[m] = '#';
        for (int i = 0; i < n; i++) {
            right[m + 1 + i] = rs.charAt(i);
        }

        int[] zright=zfun(right);
        int[] rightMatch = new int[n];
        for (int i=0; i<=n-m; i++){
            int rev=n-i-m;// start of this window in reversed s
            rightMatch[i]=Math.min(zright[m+1+rev], m);
        }

        for(int i=0;i<=n-m;i++){
            if(leftMatch[i]+rightMatch[i]>=m-1){
                return i;
            }
        }

        return -1;
    }
}