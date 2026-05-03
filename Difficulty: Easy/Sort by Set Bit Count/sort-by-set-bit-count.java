class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        int n=arr.length;
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=arr[i];
            a[i][1]=Integer.bitCount(arr[i]);
        }
        ArrayList<Integer> res=new ArrayList<>();
        Arrays.sort(a, (x,y)->y[1]-x[1]);
        for(int i=0;i<n;i++){
            res.add(a[i][0]);
        }
        return res;
    }
}