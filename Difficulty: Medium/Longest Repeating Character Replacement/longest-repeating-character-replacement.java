class Solution {
    public int longestSubstr(String s, int k) {
        int n=s.length();
        if(k>=n) return n;
        int l=k, r=n, res=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(valid(s, mid, k)){
                res=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return res;
    }
    private boolean valid(String s, int len, int k){
        int[] freq=new int[26];
        int l=0;
        for(int r=0;r<s.length();r++){
            int idx = s.charAt(r) - 'A';
            freq[idx]++;
            if(r - l + 1 > len){
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            if(r - l + 1 == len){
                int maxFreq = 0;
                for(int f : freq){
                    maxFreq = Math.max(maxFreq, f);
                }
                if(len - maxFreq <= k) return true;
            }
        }
        return false;
    }
}
