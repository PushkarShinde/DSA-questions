class Solution {
    public boolean canSplit(int arr[]) {
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        
        int cur=0;
        for(int i:arr){
            cur+=i;
            if(cur==target) return true;
        }
        return false;
    }
}