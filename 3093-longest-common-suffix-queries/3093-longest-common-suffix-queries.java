class Solution {

    class Node{
        Node[] next=new Node[26];
        int ind=-1;
        int len=Integer.MAX_VALUE;
    }

    Node root=new Node();

    private void update(Node node, int ind, int len){
        if(len<node.len || (len==node.len && ind<node.ind)){
            node.len=len;
            node.ind=ind;
        }
    }

    private void insert(String s, int ind){
        Node cur=root;
        update(cur, ind, s.length());

        for(int i=s.length()-1;i>=0;i--){
            int ch=s.charAt(i)-'a';
            if(cur.next[ch]==null){
                cur.next[ch]=new Node();
            }

            cur=cur.next[ch];
            update(cur, ind, s.length());
        }
    }

    private int search(String s){
        Node cur=root;
        for(int i=s.length()-1;i>=0;i--){
            int ch=s.charAt(i)-'a';
            if(cur.next[ch]==null) break;

            cur=cur.next[ch];
        }
        return cur.ind;
    }

    public int[] stringIndices(String[] container, String[] query) {
        int n=container.length;
        int m=query.length;
        
        for(int i=0;i<n;i++){
            insert(container[i], i);
        }

        int[] res=new int[m];
        for(int i=0;i<m;i++){
            res[i]=search(query[i]);
        }

        return res;
    }
}