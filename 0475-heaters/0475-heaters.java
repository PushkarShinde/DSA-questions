class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l=0, r=(int)1e9;
        int res=0;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(valid(mid, houses, heaters)){
                res=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }

    private boolean valid(int rad, int[] houses, int[] heaters){
        int m=houses.length;
        int n=heaters.length;
        int i=0, j=0;
        while(i<m){
            if(j==n) return false;
            long left=(long)heaters[j]-rad; 
            long right=(long)heaters[j]+rad;
            if(houses[i]<left){
                return false;
            }else if(houses[i]>right){
                j++;
            }else{
                i++;
            }
        }
        return true;
    }

    private int lowerBound(int target, int[] arr){
        int l=0, r=arr.length-1;
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=target){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    private int upperBound(int target, int[] arr){
        int l=0, r=arr.length-1;
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>target){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}