class Solution {
    private int mod=(int)1e9+7;
    public int maxSumMinProduct(int[] nums){
        int n=nums.length;
        long[] pre = new long[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        Deque<Integer> stack=new ArrayDeque<>();
        int[] left=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            left[i]=(stack.isEmpty())?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        int[] right=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            right[i]=(stack.isEmpty())?n:stack.peek();
            stack.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            long sum=pre[right[i]]-pre[left[i]+1];
            long prod=(long)nums[i]*sum;
            ans=Math.max(ans,prod);
        }
        return (int)(ans%mod);
    }
}