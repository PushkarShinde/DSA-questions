class Solution {
    boolean canFormPalindrome(String s) {
        Map<Character, Integer> map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int odd=0;
        for(int val:map.values()){
            if((val&1)==1) odd++;
            if(odd>1) return false;
        }
        return true;
    }
}