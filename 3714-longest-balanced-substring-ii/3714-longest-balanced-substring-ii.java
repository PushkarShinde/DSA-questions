class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int maxLen=0;
        // 1. longest run of same char
        int run = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                run++;
            } else {
                maxLen = Math.max(maxLen, run);
                run = 1;
            }
        }
        maxLen = Math.max(maxLen, run);

        //two at a time
        char[] chars={'a', 'b', 'c'};
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                maxLen = Math.max(maxLen, longestTwoChars(s,chars[i],chars[j]));
            }
        }

        // 3. Three distinct chars: equal counts
        maxLen = Math.max(maxLen, longestThreeChars(s));
        return maxLen;
    }
    private int longestTwoChars(String s, char c1, char c2){
        int n = s.length();
        int left=0;
        int maxLen=0;
        while(left<n){
            
            while(left<n && (s.charAt(left)!=c1 && s.charAt(left)!=c2)) left++;
            if(left>=n) break;

            int right=left;
            while(right<n && (s.charAt(right)==c1 || s.charAt(right)==c2)) right++;

            maxLen=Math.max(maxLen, compute(s, left, right-1, c1, c2));
            left=right;
        }
        return maxLen;
    }

    private int compute(String s, int l, int r, char c1, char c2){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, l-1);
        int cnt1 = 0, cnt2 = 0;
        int maxLen = 0;
        for (int i = l; i<=r; i++) {
            char c = s.charAt(i);
            if (c == c1) cnt1++;
            else if (c == c2) cnt2++;
            int diff = cnt1 - cnt2;
            if (map.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return maxLen;
    }

    private int longestThreeChars(String s){
        int n = s.length();
        Map<Long, Integer> map = new HashMap<>();
        map.put(encode(0, 0), -1);
        int cntA = 0, cntB = 0, cntC = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') cntA++;
            else if (c == 'b') cntB++;
            else cntC++;

            int diff1 = cntA - cntB;
            int diff2 = cntA - cntC;

            long key = encode(diff1, diff2);
            if (map.containsKey(key)) {
                int start = map.get(key) + 1;
                if (hasAllThree(s, start, i)) {
                    maxLen = Math.max(maxLen, i - start + 1);
                }
            } else {
                map.put(key, i);
            }
        }
        return maxLen;
    }
    private boolean hasAllThree(String s, int l, int r){
        boolean hasA = false, hasB = false, hasC = false;
        for (int i = l; i <= r; i++) {
            char c = s.charAt(i);
            if (c == 'a') hasA = true;
            else if (c == 'b') hasB = true;
            else hasC = true;
            if (hasA && hasB && hasC) return true;
        }
        return false;
    }
    private long encode(int d1, int d2){
        return (long)(d1+100000)*200001L+(d2+100000);
    }
}