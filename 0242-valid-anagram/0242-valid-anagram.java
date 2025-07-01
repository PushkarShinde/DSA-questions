class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map=new HashMap<>();
        // Map<Character, Integer> mapt=new HashMap<>();
        for(char c: s.toCharArray()){
            // if(c==' ' || c==',') continue;
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c: t.toCharArray()){
            // if(c==' ' || c==',') continue;
            map.put(c,map.getOrDefault(c,0)-1);
            if(map.get(c)<0) return false;
        }
        // for(Map.Entry<Character, Integer> entry: map.entrySet()){
        //     if(mapt.get(entry.getKey())!=entry.getValue()) return false;
        // }

        for(int val: map.values()){
            if(val!=0) return false;
        }
        return true; 
    }
}