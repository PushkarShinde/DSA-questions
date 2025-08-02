class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        // int[] left=new int[n];
        // int[] right=new int[n];
        // for(int i=0;i<n;i++){
        //     while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
        //         st.pop();
        //     }
        //     left[i]=st.isEmpty()?-1:st.peek();
        //     st.push(i);
        // }
        // st.clear();
        // for(int i=n-1;i>=0;i--){
        //     while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
        //         st.pop();
        //     }
        //     right[i]=st.isEmpty()?n:st.peek();
        //     st.push(i);
        // }
        // for(int i=0;i<n;i++){
        //     maxHt=Math.max(maxHt, (right[i]-left[i]-1)*heights[i]);
        // }
        // return maxHt;

        for(int i=0;i<=n;i++){
            int ht=(i==n)?0:heights[i];
            while(!st.isEmpty() && ht<heights[st.peek()]){
                int height=heights[st.pop()];
                int width=st.isEmpty()?i:i-st.peek()-1;
                maxArea=Math.max(maxArea, width*height);
            }
            st.push(i);
        }
        return maxArea;
    }
}