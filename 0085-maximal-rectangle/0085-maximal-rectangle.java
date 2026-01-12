class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix[0].length;
        int n=matrix.length;
        int[] ht=new int[m];
        int maxArea=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1') ht[j]++;
                else ht[j]=0;
            }
            int[] nse=new int[m];
            int[] pse=new int[m];
            Arrays.fill(nse,m);
            Arrays.fill(pse,-1);
            Stack<Integer> st=new Stack<>();
            for(int k=m-1;k>=0;k--){
                while(!st.isEmpty() && ht[st.peek()]>=ht[k]){
                    st.pop();
                }
                nse[k]=st.isEmpty()?m:st.peek();
                st.push(k);
            }
            st.clear();
            for(int k=0;k<m;k++){
                while(!st.isEmpty() && ht[st.peek()]>=ht[k]){
                    st.pop();
                }
                pse[k]=st.isEmpty()?-1:st.peek();
                st.push(k);
            }
            for(int j=0;j<m;j++){
                maxArea=Math.max(maxArea,(nse[j]-pse[j]-1)*ht[j]);
            }
        }
        return maxArea;
    }
}