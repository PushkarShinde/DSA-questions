class Solution {
    int[] tree;
    int size;
    private void segmentTree(int[] a){
        int n=a.length;
        this.tree=new int[4*n];
        this.size=n;
        build(1,a, 0, n-1);
    }
    private void build(int node,int[] a, int l, int r){
        if(l==r){
            tree[node]=a[l];
            return;
        }
        int mid=l+(r-l)/2;
        build(2*node, a,l,mid);
        build(2*node+1, a,mid+1, r);
        tree[node]=tree[2*node]+tree[2*node+1];
    }
    private int query(int ql, int qr){
        return query(1, ql, qr, 0, size-1);
    }
    private int query(int node, int ql, int qr, int l, int r){
        if(ql>r || qr<l) return 0;
        if(qr>=r && ql<=l) return tree[node];
        int mid=l+(r-l)/2;
        int left=query(2*node, ql, qr, l, mid);
        int right=query(2*node+1, ql, qr, mid+1, r);
        return left+right;
    }
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {
        segmentTree(arr);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<2*q;i+=2){
            int l=queries[i], r=queries[i+1];
            ans.add(query(l-1,r-1));
        }
        return ans;
    }
}