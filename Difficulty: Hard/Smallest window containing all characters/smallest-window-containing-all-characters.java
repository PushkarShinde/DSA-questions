class Solution {
    public static String minWindow(String s, String p) {
        if(s.length()<p.length()) return "";
        
        Map<Character, Integer> freq = new HashMap<>();
        for(char c:p.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int required=freq.size();
        int made=0;
        
        Map<Character, Integer> map=new HashMap<>();
        int l=0, bestL=0;
        int bestLen=Integer.MAX_VALUE;

        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            map.put(c, map.getOrDefault(c,0)+1);
            
            if(freq.containsKey(c) && map.get(c)==freq.get(c)){
                made++;
            }
            
            while(made==required){
                if(bestLen>r-l+1){
                    bestLen=r-l+1;
                    bestL=l;
                }

                char left=s.charAt(l);
                map.put(left,map.get(left)-1);
                
                if(freq.containsKey(left) && map.get(left)<freq.get(left)){
                    made--;
                }
                l++;
            }
        }
        return bestLen==Integer.MAX_VALUE?"":s.substring(bestL, bestL+bestLen);
    }
}