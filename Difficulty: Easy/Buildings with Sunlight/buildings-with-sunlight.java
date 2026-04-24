class Solution {
    public int visibleBuildings(int arr[]) {
        int ans=0;
        int pre=arr[0];
        for(int i:arr){
            if(i>=pre){
                ans++; 
                pre=i;
            }
        }
        
        return ans;
    }
}