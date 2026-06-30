class Solution {
    public long countOfSubstrings(String s, int k) {
        return atleast(s,k)-atleast(s,k+1);
    }
    private long atleast(String s,int k){
        int n=s.length();
        long res=0;
        int l=0;
        Map<Character, Integer> map=new HashMap<>();
        long cons=0;

        for(int r=0;r<n;r++){
            char ch=s.charAt(r);
            if(vovel(ch)) map.put(ch, map.getOrDefault(ch,0)+1);
            else cons++;

            while(map.size()==5 && cons>=k){
                res+=n-r;
                
                char pre=s.charAt(l);
                if(vovel(pre)){
                    map.put(pre, map.get(pre)-1);
                    if(map.get(pre)==0) map.remove(pre);
                }else cons--;

                l++;
            }
        }

        return res;
    }

    private boolean valid(Map<Character, Integer> map, int cons, int k){
        return map.size()==5 && cons==k;
    }

    private boolean vovel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}