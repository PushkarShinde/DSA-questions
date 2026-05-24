class Solution {
    public int coin(int[] arr) {
        int l=0, r=arr.length-1;
        while(l<r){
            if(arr[l]<arr[r]){
                r--;
            }else{
                l++;
            }
            if(r-l+1==1){
                break;
            }
        }
        return arr[l];
    }
}