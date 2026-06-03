class Solution {
    Map<Integer, List<Integer>> map;
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        map=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        int n=arr.length;
        
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
        }
        
        for(int[] q:queries){
            int l=q[0], r=q[1], x=q[2];
            res.add(solve(l,r,x));
        }
        return res;
    }
    
    private int solve(int l,int r,int x){
        if(!map.containsKey(x)) return 0;
        
        List<Integer> ind=map.get(x);
        int lower=lowerBound(ind, l);
        int upper=upperBound(ind, r);
        return upper-lower;
    }
    
    private int upperBound(List<Integer> ind, int x){
        int l=0, r=ind.size()-1;
        while(l<=r){
            int mid=(l+r+1)>>>1;
            if(ind.get(mid)<=x){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l;
    }
    private int lowerBound(List<Integer> ind, int x){
        int l=0, r=ind.size()-1;
        while(l<=r){
            int mid=(l+r+1)>>>1;
            if(ind.get(mid)>=x){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}