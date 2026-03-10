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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */