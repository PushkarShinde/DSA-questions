class Solution {
    class Node{
        private Map<Character, Node> links;
        private String word=null;
        private int count=0;

        Node(){
            this.links=new HashMap<>();
        }

        public void remove(char ch){
            links.remove(ch);
        }

        public Node get(char ch){
            return links.get(ch);
        }

        public int getCount(){
            return count;
        }
        
        public void setCount(){
            count++;
        }

        public void unsetCount(){
            count--;
        }

        public boolean containsKey(char ch){
            return links.containsKey(ch);
        }

        public void put(char ch, Node node){
            links.putIfAbsent(ch,node);
        }

        public void setEnd(String s){
            word=s;
        }

        public boolean isEnd(){
            return word!=null;
        }

        public String getWord(){
            return word;
        }
    }

    private char[][] board;
    private int n, m;
    List<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        this.n=board.length;
        this.m=board[0].length;
        this.board=board;
        res=new ArrayList<>();

        Node root=new Node();
        for(String s: words){
            Node node=root;
            for(char c:s.toCharArray()){
                node.put(c,new Node());
                node=node.get(c);
                node.setCount();
            }
            node.setEnd(s);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(i,j, root);
            }
        }

        return res;
    }

    private int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};

    private void dfs(int i, int j, Node node){
        if(i<0 || j<0 || i>=n || j>=m) return;
        char c=board[i][j];
        if(c=='#' || !node.containsKey(c)) return;
        Node next=node.get(c);
        if(next.isEnd()){
            res.add(next.getWord());
            next.setEnd(null);//to avoid duplicate
        }
        if(next.getCount()==0) return;

        board[i][j]='#';
        for(int[] d:dir){
            dfs(i+d[0], j+d[1],next);
        }
        board[i][j]=c;

        // next.unsetCount();
        // if(next.getCount()==0){
        //     node.remove(c);
        // }
    }

    /*
    DFS - O(k.n.m.3^l) 
    where:  k=words.length
            l=words[i].length

    private char[][] board;
    private int n;
    private int m;
    private boolean[][] vis;

    public List<String> findWords(char[][] board, String[] words) {
        this.n=board.length;
        this.m=board[0].length;
        this.board=board;
        List<String> res=new ArrayList<>();

        for(String word: words){
            boolean found=false;
    
            outer: for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(board[i][j]==word.charAt(0)){
                        vis=new boolean[n][m];
                        vis[i][j]=true;
                        if(dfs(i,j,1, word)){
                            found=true;
                            break outer;
                        }
                    }
                }
            }
            if(found) res.add(word);
        }
        return res;
    }

    private int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
    private boolean dfs(int i, int j, int ind, String word){
        if(ind==word.length()) return true;
        for(int[] d:dir){
            int ni=i+d[0];
            int nj=j+d[1];
            if(ni<0 || nj<0 || ni>=n || nj>=m || vis[ni][nj]) continue;
            if(board[ni][nj]==word.charAt(ind)){
                vis[ni][nj]=true;
                if(dfs(ni,nj,ind+1, word)) return true;
                vis[ni][nj]=false;
            }
        }
        return false;
    }
    */
}