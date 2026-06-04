class Solution {
    int[] one, zero;
    int maxSubstring(String s) {
        int n=s.length();
        int one=0;
        for(char c:s.toCharArray()){
            if(c=='1') one++;
        }
        if(one==n) return -1;
        
        int ans=0;
        int local=0;
        for(int i=0;i<n;i++){
            int num=(s.charAt(i)=='0'?1:-1);
            local=Math.max(local+num, num);
            ans=Math.max(local, ans);
        }
        return ans;
    }
}