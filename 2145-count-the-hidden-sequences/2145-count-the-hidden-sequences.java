class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long minPrefix = 0, maxPrefix = 0, sum = 0;
        for (int diff : differences){
            sum += diff;
            minPrefix=Math.min(minPrefix,sum);
            maxPrefix=Math.max(maxPrefix,sum);
        }
        long minStart = lower - minPrefix;
        long maxStart = upper - maxPrefix;
        return (int)Math.max(0, maxStart - minStart + 1); // count cannot be negative
    }

    //My Brute Force gives TLE beacuse it check each element in lower and upper bound

   /*  public int numberOfArrays(int[] differences, int lower, int upper) {
        int firstLastDiff = 0, n = differences.length, c =0;

        for(int diff: differences) firstLastDiff+=diff;

        for(int i = lower;i<=upper;i++){
            int prev = i;
            for(int j=0;j<n;j++){
                prev = differences[j] + prev;
                if(prev<lower || prev>upper){
                    break;
                }
                if(j == n-1){
                    if(prev != i+firstLastDiff) break;
                    c++;
                }
            }
        }

        return c;
    }*/
}