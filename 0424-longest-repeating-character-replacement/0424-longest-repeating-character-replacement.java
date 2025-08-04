class Solution {
    public int characterReplacement(String s, int k) {
        int[] map=new int[26];
        int n=s.length();
        int left=0;
        int maxLen=0;
        int maxFreq=0;

        for(int right=0; right<n;right++){
            map[s.charAt(right)-'A']++;
            maxFreq=Math.max(maxFreq, map[s.charAt(right)-'A']);
            while(right-left+1-maxFreq>k){
                // map.put(s.charAt(left), map.get(s.charAt(left))-1);
                map[s.charAt(left)-'A']--;
                left++;
            }
            maxLen=Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}