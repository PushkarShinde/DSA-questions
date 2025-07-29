class Solution {
    // private int mod=1000_000_007; 
    private int mod=(int)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        long sum=0;
        int n=arr.length;
        //Efficient Approach: Monotonic Stack
        //We’ll calculate, for each arr[i], how many subarrays where arr[i] is the minimum element, 
        //then multiply it by arr[i].
        /**
        Insight:
        Let’s say for each element arr[i], we know:
        prevSmaller[i] = index of Previous Less Element (PLE) (first to the left that is strictly less than arr[i]
        nextSmaller[i] = index of Next Less Element (NLE) (first to the right that is less or equal than arr[i])
        Then:
        Number of subarrays where arr[i] is the minimum = (i - PLE) × (NLE - i)
        So arr[i] contributes arr[i] × (i - PLE) × (NLE - i) to the final sum
         */
        int[] preMin=new int[n];
        int[] postMin=new int[n];
        Stack<Integer> st=new Stack<>();
        // Find PLE (strictly less)
        for (int i = 0; i < n; i++) { //pre ke liye
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
            }
            preMin[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }

        st.clear();
        // Find NLE (less or equal to maintain strict min)
        for (int i = n-1; i >=0; i--) { //post ke liye
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            postMin[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }

        for(int i=0;i<n;i++){
            long right=postMin[i]-i;
            long left=i-preMin[i];
            sum=(sum+(left%mod)*(right%mod)*arr[i])%mod;
        }
        return (int)sum;
    }
}