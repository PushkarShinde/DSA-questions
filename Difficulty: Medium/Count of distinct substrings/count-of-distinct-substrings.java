class Solution {
    static class Node{
        private Node[] links=new Node[26];
        
        public void put(char ch, Node node){
            links[ch-'a']=node;
        }
        
        public Node get(char ch){
            return links[ch-'a'];
        }
        
        public boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
    }

    public static int countSubs(String s) {
        int n=s.length();
        Node root=new Node();
        int distinct=0;
        
        for(int i=0;i<n;i++){
            Node node=root;
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                if(!node.containsKey(ch)){
                    node.put(ch, new Node());
                    distinct++;
                }
                node=node.get(ch);
            }
        }
        
        return distinct;
    }
}