class Solution {
    public int minNumberOperations(int[] target) {
        int[] diff=target.clone();
        int res=diff[0];
        for(int i=1;i<diff.length;i++){
            if(diff[i]>diff[i-1]) res+=(diff[i]-diff[i-1]);
        }
        return res;
    }
}