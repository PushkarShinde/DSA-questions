class Solution {
    public String findLargest(int[] arr) {
        int n=arr.length;
        Integer[] a=new Integer[n];
        for(int i=0;i<n;i++){
            a[i]=arr[i];
        }
        Arrays.sort(a, (x,y)->{
            String s1=Integer.toString(x);
            String s2=Integer.toString(y);
            return (s2+s1).compareTo(s1+s2);//descending
        });
        StringBuilder res=new StringBuilder();
        for(int ar:a){
            res.append(ar);
        }
        if(res.charAt(0)=='0') return "0";
        return res.toString();
    }
}