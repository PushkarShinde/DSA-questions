class Solution {
    class Trie{
        Trie[] node=new Trie[26];
        int freq=0;
    }
    
    Trie root;
    
    private void insert(String s){
        int n=s.length();
        Trie cur=root;
        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'a';
            if(cur.node[c]==null){
                cur.node[c]=new Trie();
            }
            cur=cur.node[c];
            cur.freq++;
        }
    }
    
    private String find(String s){
        int n=s.length();
        Trie cur=root;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'a';
            cur=cur.node[c];
            res.append(s.charAt(i));
            if(cur.freq==1) break;
        }
        
        return res.toString();
    }
    
    public ArrayList<String> findPrefixes(String[] arr) {
        int n=arr.length;
        ArrayList<String> res=new ArrayList<>();
        
        root=new Trie();
        
        for(String s:arr){
            insert(s);
        }
        
        for(String s:arr){
            res.add(find(s));
        }
        
        return res;
    }
}





