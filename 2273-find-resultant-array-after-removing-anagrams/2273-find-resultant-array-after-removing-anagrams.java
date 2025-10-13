class Solution {
    public List<String> removeAnagrams(String[] words){
        List<String> res=new ArrayList<>();
        int n=words.length;
        res.add(words[0]);
        for(int i=1;i<n;i++){
            String s=words[i];
            if(!isAnagram(res.get(res.size()-1), s)){
                res.add(s);
            }
        }
        return res;
    }
    private boolean isAnagram(String a, String b){
        int n1=a.length();
        int n2=b.length();
        if(n1!=n2) return false;
        int[] fre=new int[26];
        for(char c: a.toCharArray()){
            fre[c-'a']++;
        }
        for(char c: b.toCharArray()){
            fre[c-'a']--;
        }
        for(int i:fre){
            if(i!=0) return false;
        }
        return true;
    }
}