class Solution {
    class Node{
        char ch;
        int freq;
        int minInd;
        Node left, right;
        
        Node(char ch, int freq, int minInd){
            this.ch=ch;
            this.freq=freq;
            this.minInd=minInd;
        }
    }
    
    int orderCounter;
    public ArrayList<String> huffmanCodes(String s, int f[]) {
        orderCounter=0;
        int n=s.length();
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->{
            if(a.freq!=b.freq) return Integer.compare(a.freq, b.freq);
            return Integer.compare(a.minInd, b.minInd);
        });
        
        for(int i=0;i<n;i++){
            pq.offer(new Node(s.charAt(i), f[i], i));
        }
        
        while(pq.size()>1){
            Node left=pq.poll();
            Node right=pq.poll();
            
            Node merge=new Node('\0', left.freq+right.freq, Math.min(left.minInd, right.minInd));
            merge.left=left;
            merge.right=right;
            
            pq.offer(merge);
        }
        
        Node root=pq.poll();
        ArrayList<String> res = new ArrayList<>();
        
        if (root.left == null && root.right == null) {
            res.add("0");
            return res;
        }
        
        preorder(res, root, "");
        return res;
    }
    
    private void preorder(ArrayList<String> res, Node node, String code){
        if(node==null) return;
        
        if(node.left==null && node.right==null) {
            res.add(code);
            return;
        }
        
        preorder(res, node.left, code+"0");
        preorder(res, node.right, code+"1");
    }
}