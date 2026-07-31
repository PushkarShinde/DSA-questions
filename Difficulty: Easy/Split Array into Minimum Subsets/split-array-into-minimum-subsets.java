class Solution {
    int minSubsets(int arr[]) {
        int n=arr.length;
        Arrays.sort(arr);
        int pre=arr[0];
        int count=0;
        for(int i=0;i<n;i++){
            int cur=arr[i];
            if(pre+1==cur){
                pre=cur;
                continue;
            }
            count++;
            pre=cur;
        }
        
        return count;
    }
}