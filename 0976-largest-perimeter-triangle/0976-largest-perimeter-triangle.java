class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=n-1;i>=2;i--){
            int a=nums[i];
            int b=nums[i-1];
            int c=nums[i-2];
            if(check(a,b,c)){
                return a+b+c;
            }
        }
        return 0;
    }
    private boolean check(int a, int b, int c){
        double s=(a+b+c)/2.0;
        double area=s*(s-a)*(s-b)*(s-c);
        if(area!=0 && b+c>a){
            return true;
        }
        return false;
    }
}