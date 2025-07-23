
class Solution {
    private static int[] spf;
    private static final int MAX=200001;
    
    public static int sieve(){
        if (spf != null) {
            return 0; // Already initialized
        }
        
        spf = new int[MAX];
        // Initialize spf[i] = i
        for (int i = 0; i < MAX; i++) {
            spf[i] = i;
        }
        // 0 and 1 are not prime
        spf[0] = spf[1] = 1;
        
        // Sieve of Eratosthenes for smallest prime factor
        for (int i = 2; i * i < MAX; i++) {
            if (spf[i] == i) { // i is prime
                for (int j = i * i; j < MAX; j += i) {
                    if (spf[j] == j) { // Only update if j hasn't been marked
                        spf[j] = i;
                    }
                }
            }
        }
        
        return 0; // Dummy return value
    }
    public static List<Integer> findPrimeFactors(int N) {
        // Ensure sieve is called
        if (spf == null) {
            sieve();
        }
        List<Integer> factors = new ArrayList<>();
        while (N > 1) {
            factors.add(spf[N]);
            N /= spf[N];
        }
        
        return factors;
    }
};