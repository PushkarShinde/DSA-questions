class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n=nums.length;
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int val=nums[i];
            map.computeIfAbsent(val,k->new ArrayList<>()).add(i);
        }

        int minDist=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int reverse=rev(nums[i]);
            if(!map.containsKey(reverse)) continue;

            List<Integer> list=map.get(reverse);
            int ind=upper(list, i);
            if(ind<list.size()){
                minDist=Math.min(minDist, list.get(ind)-i);
            }
        }

        return minDist==Integer.MAX_VALUE?-1:minDist;
    }

    private int upper(List<Integer> list, int tar){
        int l=0, r=list.size();
        int ans=0;
        while(l<r){
            int mid=l+(r-l)/2;
            if(list.get(mid)<=tar){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
    
    private int rev(int num){
        int res=0;
        while(num>0){
            res=res*10+num%10;
            num/=10;
        }
        
        return res;
    }
}