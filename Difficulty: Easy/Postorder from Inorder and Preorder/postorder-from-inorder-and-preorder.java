/*prints the post order traversal of the
tree */
class GfG {
    int preIndex=0;
    Map<Integer, Integer> inMap=new HashMap<>();    
    
    void printPostOrder(int in[], int pre[]) {
        int n=in.length;
        for(int i=0;i<n;i++){
            inMap.put(in[i], i);
        }
        postorder(pre, 0, n-1);
    }
    
    void postorder(int[] pre, int start, int end){
        if(start>end) return;
        int rootVal=pre[preIndex++];
        int rootInd=inMap.get(rootVal);
        
        postorder(pre,start,rootInd-1);
        postorder(pre,rootInd+1,end);
        System.out.print(rootVal+" ");
    }
}