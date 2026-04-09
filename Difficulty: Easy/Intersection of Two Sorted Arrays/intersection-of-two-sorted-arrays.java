class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        int n=a.length;
        int m=b.length;
        Arrays.sort(a);
        Arrays.sort(b);
        Set<Integer> set=new LinkedHashSet<>();
        
        int l=0, r=0;
        while(l<n && r<m){
            if(a[l]==b[r]){
                set.add(a[l]);
                l++; 
                r++;
            }else if(a[l]<b[r]){
                l++;
            }else{
                r++;
            }
        }
        
        return new ArrayList<>(set);
    }
}