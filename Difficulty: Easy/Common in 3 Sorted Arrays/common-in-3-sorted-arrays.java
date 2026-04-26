class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> res=new ArrayList<>();
        int ai=0, bi=0, ci=0;
        int p=a.length;
        int q=b.length;
        int r=c.length;
        while(ai<p && bi<q && ci<r){
            if(a[ai]==b[bi] && a[ai]==c[ci]) {
                if(res.size()==0 || res.get(res.size()-1)!=a[ai])
                    res.add(a[ai]);
                ai++;
                bi++;
                ci++;
            }else{
                int min=Math.min(a[ai], Math.min(b[bi], c[ci]));
                if(a[ai]==min) ai++;
                if(b[bi]==min) bi++;
                if(c[ci]==min) ci++;
            }
        }
        return res;
    }
}