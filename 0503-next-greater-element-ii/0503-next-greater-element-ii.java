class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        int[] res=new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            res[i%n]=st.isEmpty()?-1:st.peek();
            st.add(nums[i%n]);
        }
        return res;
    }
}