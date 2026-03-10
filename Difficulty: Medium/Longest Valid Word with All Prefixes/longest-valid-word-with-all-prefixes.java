class Solution {
    class Node{
        private Node[] links=new Node[26];
        private boolean flag=false;
        
        public boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        
        public Node get(char ch){
            return links[ch-'a'];
        }
        
        public void setEnd(){
            flag=true;
        }
        
        public boolean isEnd(){
            return flag;
        }
        
        public void put(char ch, Node node){
            links[ch-'a']=node;
        }
    }

    class Trie {
        private static Node root;
        
        public Trie() {
            root=new Node();
        }
        
        public void insert(String word){
            Node node=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(!node.containsKey(ch)){
                    node.put(ch, new Node());
                }
                node=node.get(ch);
            }
            node.setEnd();
        }
        
        public boolean search(String word){
            Node node=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(node.containsKey(ch)){
                    node=node.get(ch);
                }else{
                    return false;
                }
            }
            return node.isEnd();
        }
        
        public boolean startsWith(String prefix){
            Node node=root;
            for(int i=0;i<prefix.length();i++){
                char ch=prefix.charAt(i);
                if(node.containsKey(ch)){
                    node=node.get(ch);
                }else{
                    return false;
                }
            }
            return node!=null;
        }
    }

    public String longestValidWord(String[] words) {
        Trie trie=new Trie();
        for(String w:words){
            trie.insert(w);
        }
        String res="";
        for(String w:words){
            int n=w.length();
            boolean valid=true;
            for(int i=1;i<=n;i++){
                String sub=w.substring(0,i);
                if(!trie.search(sub)){
                    valid=false;
                    break;
                }
            }
            if(valid){
                if(res.length()<n || (res.length()==n && w.compareTo(res)<0)){
                    res=w;
                }
            }
        }
        return res;
    }
}