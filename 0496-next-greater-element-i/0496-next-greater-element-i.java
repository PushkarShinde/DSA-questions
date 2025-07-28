class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=m-1;i>=0;i--){
            int num=nums2[i];
            while(!st.isEmpty() && st.peek()<=num){
                st.pop();
            }
            map.put(num, st.isEmpty()?-1:st.peek());
            st.push(num);
        }
        for(int i=0;i<n;i++){
            res[i]=map.get(nums1[i]);
        }
        return res;
    }
}