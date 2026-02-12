class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int res=0;
        for(int l=0;l<n;l++){
            Map<Character, Integer> map=new HashMap<>();
            for(int r=l;r<n;r++){
                char c=s.charAt(r);
                map.put(c, map.getOrDefault(c,0)+1);
                int pre=map.get(c);
                boolean equal=true;
                for(int val:map.values()){
                    if(val!=pre) {
                        equal=false;
                        break;
                    }
                    pre=val;
                }
                if(equal) res=Math.max(res, r-l+1);
            }
        }
        return res;
    }
}