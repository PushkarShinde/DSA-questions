class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        int t=0;
        // num1 - k * num2 - (sum of k powers of 2) = 0
        // sum of k powers of 2 = num1 - k * num2
        //Let target = num1 - k * num2. For this to be achievable with k operations:
        //target must be positive (can't represent negative numbers as sum of powers of 2)
        //target must have at most k bits set (each operation contributes at least one power of 2)
        //target must be at least k (minimum sum of k powers of 2 is k, when all are 2^0 = 1)

        for(int i=1;i<=60;i++){
            long target=(long)num1-(long)i*num2;
            if(target<0) break;
            if(canRepresent(target, i)) return i;
        }
        return -1;
    }

    private boolean canRepresent(long target, long op){
        int minOpNeeded=Long.bitCount(target);// Count set bits - minimum number of powers of 2 needed
        return target>=op && minOpNeeded<=op;
    }
}