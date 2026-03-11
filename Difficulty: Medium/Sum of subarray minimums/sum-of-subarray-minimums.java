class Solution {
    public int sumSubMins(int[] arr) {
        int n=arr.length;
        int res=0;
        int mod=(int)1e9+7;
        
        /*
        for(int i=0;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                min=Math.min(min, arr[j]);
                res+=min;
            }
        }
        return res;
        */
        
        Stack<Integer> stack=new Stack<>();

        int[] ple=new int[n];
        int[] nle=new int[n];
        
        for(int i=0;i<n;i++){
            int num=arr[i];
            while(!stack.isEmpty() && arr[stack.peek()]>num){
                stack.pop();
            }
            ple[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=n-1;i>=0;i--){
            int num=arr[i];
            while(!stack.isEmpty() && arr[stack.peek()]>=num){
                stack.pop();
            }
            nle[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        
        for(int i=0;i<n;i++){
            int l=i-ple[i];
            int r=nle[i]-i;
            res=(res+arr[i]*l*r)%mod;
        }
        
        return res;
    }
}
