// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }


class Solution {
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        
        Info(boolean isBST, int size, int min, int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    static int maxSize;
    
    static int largestBst(Node root) {
        maxSize=0;
        solve(root);
        return maxSize;
    }
    
    private static Info solve(Node node){
        if(node==null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Info left=solve(node.left);
        Info right=solve(node.right);
        
        if(left.isBST && right.isBST &&
        left.max<node.data && node.data<right.min){
            
            int size=left.size+right.size+1;
            maxSize=Math.max(maxSize, size);
            
            int max=Math.max(right.max, node.data);
            int min=Math.min(left.min, node.data);
            
            return new Info(true, size, min, max);
        }
        
        return new Info(false, 0,0,0);
    }   
}











