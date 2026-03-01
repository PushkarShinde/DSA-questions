class Solution {
    void pushZerosToEnd(int[] arr) {
        int n=arr.length;
        int i=0;
        for(int j=0;j<n;j++){
            if(arr[j]!=0){
                arr[i]=arr[j];
                if(i!=j)arr[j]=0;
                i++;
            }
        }
    }
}