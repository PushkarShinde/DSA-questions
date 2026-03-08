class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n=arr.length;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            arr[i]=arr[i]*arr[i];
            set.add(arr[i]);
        }
        if(set.size()<3) return false;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(set.contains(arr[i]+arr[j])) return true;
            }
        }
        return false;
    }
}