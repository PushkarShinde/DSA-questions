class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int n=s.length();
        // HashSet<Character> set=new HashSet<>();\
        HashMap<Character, Integer> map=new HashMap<>();
        int maxlen=Integer.MIN_VALUE;
        while(r<n){
            char ch=s.charAt(r);
            if(map.containsKey(ch) && l<=map.get(ch)){
                l=map.get(ch)+1;
            }
    //     if(set.contains(ch)){
    //         while(l<r && set.contains(ch)){
    //             set.remove(s.charAt(l));
    //             l++;
    //         }
    //     }
    //     set.add(ch);
            map.put(ch,r);
            maxlen=Math.max(maxlen, r-l+1);
            r++;
        }
        return (s.length()==0)?0:maxlen;
    }
}