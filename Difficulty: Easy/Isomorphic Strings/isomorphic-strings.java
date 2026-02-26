class Solution {
    public boolean areIsomorphic(String s1, String s2){
        Map<Character, Character> map=new HashMap<>();
        int n=s1.length();
        int[] ch=new int[26];
        for(int i=0;i<n;i++){
            char a=s1.charAt(i);
            char b=s2.charAt(i);
            if(map.containsKey(a)){
                if(b!=map.get(a)){
                    return false;
                }else{
                    continue;
                }
            }
            if(!map.containsKey(a)){
                map.put(a,b);
                if(ch[b-'a']==1) return false;
                else ch[b-'a']=1;
            }
        }
        return true;
    }
}