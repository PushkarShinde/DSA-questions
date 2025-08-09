class Solution {
    public int numberOfSubstrings(String s) {
        int left=0;
        int n=s.length();
        int count=0;
        Map<Character, Integer> map=new HashMap<>();
        for(int right=0;right<n;right++){
            char c=s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.size()<3) continue;
            while(map.size()==3){
                count+=n-right;
                char leftChar=s.charAt(left);
                map.put( leftChar, map.get( leftChar)-1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
        }
        return count;
    }
}