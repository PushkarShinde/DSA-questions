class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n=nums.length;
        List<Integer> res=new ArrayList<>();
        for(int b:nums){
            while(!res.isEmpty()){
                int a=res.get(res.size()-1);
                int g = gcd(a, b);
                if(gcd(a,b)>1){
                    res.remove(res.size()-1);
                    b=lcm(a,b);
                }else{
                    break;
                }
            }
            res.add(b);
        }
        return res;
    }
    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
    private int lcm(int a, int b){
        return a/gcd(a,b)*b;
    }
}