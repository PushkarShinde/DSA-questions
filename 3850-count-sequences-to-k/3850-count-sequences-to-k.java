class Solution {
    private Map<String,Long> memo;
    private int n;
    private int[] nums;
    private long k;
    public int countSequences(int[] nums, long k) {
        this.nums=nums;
        this.k=k;
        this.n=nums.length;
        memo=new HashMap<>();
        return (int)solve(0, 1L, 1L);
    }
    private long solve(int i, long num, long den){
        int n=nums.length;
        if(i==n) {
            return (num==k*den)?1:0;
        }

        long g=gcd(num, den);
        num/=g;
        den/=g;

        String key =i+","+num+","+den;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long res=0;
        res+=solve(i+1,num, den);

        long newNum=num*nums[i];
        long newDen=den;
        long lcm1=gcd(newNum, newDen);
        res+=solve(i+1, newNum/lcm1, newDen/lcm1);

        if(nums[i]!=0){
            newNum=num;
            newDen=den*nums[i];
            long lcm2=gcd(newNum, newDen);
            res+=solve(i+1, newNum/lcm2, newDen/lcm2);
        }

        memo.put(key, res);
        return res;
    }

    private long gcd(long a, long b){
        return b==0?Math.abs(a):gcd(b,a%b);
    }
}