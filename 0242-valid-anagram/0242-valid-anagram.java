class Solution {
    public boolean isAnagram(String s, String t) {
        /*Map<Character, Integer> map=new HashMap<>();
        for(char c: s.toCharArray()){
            // if(c==' ' || c==',') continue;
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c: t.toCharArray()){
            // if(c==' ' || c==',') continue;
            map.put(c,map.getOrDefault(c,0)-1);
            if(map.get(c)<0) return false;
        }

        for(int val: map.values()){
            if(val!=0) return false;
        }
        */
        int m=s.length(), n=t.length();
        if(m!=n) return false;
        int[] map=new int[26];
        for(char c: s.toCharArray()){
            map[c-'a']++;
        }
        for(char c: t.toCharArray()){
            map[c-'a']--;
            if (map[c - 'a'] < 0) return false; // optional early exit
        }
        // for(int i:map){
        //     if(i!=0) return false;
        // }
        return true; 
    }
}