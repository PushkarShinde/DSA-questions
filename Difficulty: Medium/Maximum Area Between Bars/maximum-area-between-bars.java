class Solution {
    public int maxArea(List<Integer> height) {
        int n=height.size();
        if(n<3) return 0;
        
        int res=0;
        int left=0, right=n-1;
        while(left<right-1){
            int a=height.get(left);
            int b=height.get(right);
            
            res=Math.max(res, Math.min(a,b)*(right-left-1));
            if(a<b){
                left++;
            }else{
                right--;
            }
        }
        
        return res;
    }
}