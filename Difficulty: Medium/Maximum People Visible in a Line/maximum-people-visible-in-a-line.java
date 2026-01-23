class Solution {
    public int maxPeople(int[] arr) {
        int n=arr.length;
        int res=0;
        Stack<Integer> st=new Stack<>();
        int[] left=new int[n];
        for(int i=0;i<n;i++){
            int cur=arr[i];
            while(!st.isEmpty() && arr[st.peek()]<cur){
                st.pop();
            }
            left[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        int[] right=new int[n];
        for(int i=n-1;i>=0;i--){
            int cur=arr[i];
            while(!st.isEmpty() && arr[st.peek()]<cur){
                st.pop();
            }
            right[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        for(int i=0;i<n;i++){
            res=Math.max(res,right[i]-left[i]-1);
        }
        return res;
    }
}
