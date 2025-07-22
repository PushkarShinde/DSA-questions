class Solution {
    public static ArrayList<Integer> primeFac(int n) {
        ArrayList<Integer> res=new ArrayList<>();
        if(n<2) return res;
        for(int i=2;i*i<=n;i++){
            if (n % i == 0) {
                if (isPrime(i)) res.add(i);
                int other = n / i;
                if (other != i && isPrime(other)) res.add(other);
            }
        }
        // In case n itself is prime
        if (isPrime(n)) res.add(n);
    
        // Remove duplicates if any (e.g., when n is a square like 49)
        Set<Integer> set = new HashSet<>(res);
        return new ArrayList<>(set);
    }
    
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}