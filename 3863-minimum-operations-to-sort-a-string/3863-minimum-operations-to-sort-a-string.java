class Solution {
    public int minOperations(String s) {
        int n=s.length();
        if(n==1) return 0;
        char[] ch=s.toCharArray();
        char[] chs=s.toCharArray();
        Arrays.sort(chs);

        boolean sorted=true;
        for(int i=0;i<n;i++) if(ch[i]!=chs[i]) sorted=false;
        if(sorted) return 0;

        if(ch[0]==chs[0] || ch[n-1]==chs[n-1]){
            return 1;
        }else{
            if(n==2) return -1;
            int a=-1, b=-1;
            for(int i=0;i<n;i++){
                if(a==-1 && ch[i]==chs[0]) a=i;
                if(ch[i]==chs[n-1]) b=i; 
            }
            if(b==0 && a==n-1) return 3;
            else return 2;
        }
    }
}