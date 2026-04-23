class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);
        }

        long[] res=new long[n];
        for(List<Integer> ind: map.values()){
            int k=ind.size();
            if(k==1) continue;

            long[] pre=new long[k+1];
            for(int i=0;i<k;i++){
                pre[i+1]=pre[i]+ind.get(i);
            }

            for(int i=0;i<k;i++){
                int pos=ind.get(i);

                // Distance to all elements on the left
                // Σ(pos - indices[j]) for j < i
                // = i * pos - Σindices[j] for j < i
                // = i * pos - prefixSum[i]
                long left=(long)i*pos-pre[i];

                // Distance to all elements on the right
                // Σ(indices[j] - pos) for j > i
                // = Σindices[j] for j > i - (k - i - 1) * pos
                // = (prefixSum[k] - prefixSum[i+1]) - (k - i - 1) * pos
                long right=(pre[k]-pre[i+1])-(long)(k-i-1)*pos;

                res[pos]=left+right;
            }
        }

        return res;
    }
}