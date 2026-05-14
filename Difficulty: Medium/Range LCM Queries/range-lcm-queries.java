class Solution {
    long[] tree;
    int n;

    public void build(int[] a, int l, int r, int ind){
        if(l==r){
            tree[ind]=a[l];
            return;
        }
        int mid=l+(r-l)/2;
        build(a,l, mid, 2*ind);
        build(a,mid+1, r, 2*ind+1);
        tree[ind]=lcm(tree[2*ind], tree[2*ind+1]);
    }
    public long query(int l, int r){
        return query(l, r, 0, n-1, 1);
    }
    private long query(int ql, int qr, int l, int r, int ind){
        if(r<ql || l>qr) return 1L;
        if(l>=ql && r<=qr) return tree[ind];
        int mid=l+(r-l)/2;
        long left=query(ql, qr, l, mid, 2*ind);
        long right=query(ql, qr, mid+1,r, 2*ind+1);
        return lcm(left, right);
    }
    
    public void update(int i, int val){
        update(i, val, 0,n-1, 1);
    }
    private void update(int i, int val, int l, int r, int ind){
        if(l==r){
            tree[ind]=val;
            return;
        }
        
        int mid=l+(r-l)/2;
        if(i<=mid){
            update(i, val, l, mid, 2*ind);
        }else{
            update(i, val, mid+1, r, 2*ind+1);
        }
        tree[ind]=lcm(tree[2*ind], tree[2*ind+1]);
    }
    
    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        ArrayList<Long> res=new ArrayList<>();
        this.n=arr.length;
        this.tree=new long[4*n];
        build(arr, 0, n-1,1);
        for(int[] q:queries){
            int op=q[0];
            int l=q[1];
            int r=q[2];
            if(op==1){
                update(l,r);
            }else{
                res.add(query(l,r));
            }
        }
        return res;
    }
    
    private long gcd(long a, long b){
        return b==0?a:gcd(b, a%b);
    }
    private long lcm(long a, long b){
        if(a == 1) return b;
        if(b == 1) return a;
        return (a / gcd(a, b)) * b;
    }
}