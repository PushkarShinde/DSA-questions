class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            res[i]=solve(nums, i,i+k-1,x);
        }
        return res;
    }
    private int solve(int[] nums, int i, int j, int x){
        Map<Integer, Integer> map=new HashMap<>();
        for(int k=i;k<=j; k++){
            map.put(nums[k], map.getOrDefault(nums[k],0)+1);
        }
        List<int[]> fre=new ArrayList<>();
        for(int key: map.keySet()){
            int val=map.get(key);
            fre.add(new int[]{val, key});
        }
        fre.sort((a,b)->{
            if(b[0]==a[0]){
                return b[1]-a[1];
            }
            return b[0]-a[0];
        });
        
        int count=Math.min(x,fre.size());
        int sum=0;
        for(int f=0;f<count;f++){
            int val=fre.get(f)[0], key=fre.get(f)[1];
            sum+=key*val;
        }
        return sum;
    }
}