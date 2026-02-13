/* The functions which
builds the segment tree */
class GfG {
    static int tree[];
    static int size;
    public static int[] constructST(int arr[], int n) {
        size=n;
        tree=new int[4*n];
        build(arr, 1, 0, n-1);
        return tree;
    }
    
    private static void build(int[] a, int node, int l, int r){
        if(l==r) {
            tree[node]=a[l];
            return;
        }
        int mid=l+(r-l)/2;
        build(a, 2*node, l, mid);
        build(a, 2*node+1, mid+1, r);
        tree[node]=Math.min(tree[2*node], tree[2*node+1]);
    }
    
    private static int query(int ql, int qr){
        return query(ql, qr,1, 0 ,size-1);
    }
    
    private static int query(int ql, int qr, int node, int l, int r){
        if(r<ql || l>qr) return Integer.MAX_VALUE;
        if(l>=ql && r<=qr) return tree[node];
        int mid=l+(r-l)/2;
        int left=query(ql, qr, 2*node, l, mid);
        int right=query(ql, qr, 2*node+1, mid+1, r);
        return Math.min(left, right);
    }
    
    public static int RMQ(int st[], int n, int l, int r) {
        return query(l,r);
    }
}