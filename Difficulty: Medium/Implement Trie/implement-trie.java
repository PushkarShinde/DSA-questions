class Node{
    Node[] links=new Node[26];
    boolean flag=false;
    public Node(){
        
    }
    
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    
    Node get(char ch){
        return links[ch-'a'];
    }
    
    void put(char ch, Node node){
        links[ch-'a']=node;
    }
    
    void setEnd(){
        flag=true;
    }
    
    boolean isEnd(){
        return flag;
    }
}

class Trie {
    private static Node root;
    
    public Trie() {
        root=new Node();
    }

    public void insert(String word){//O(word.length())
        Node node=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
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

    public boolean isPrefix(String word){
        Node node=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(node.containsKey(ch)){
                node=node.get(ch);
            }else{
                return false;
            }
        }
        return node!=null;
    }
}