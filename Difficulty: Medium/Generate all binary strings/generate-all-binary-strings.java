// User function Template for Java

class Solution {
    public static List<String> generateBinaryStrings(int n) {
        List<String> ans=new ArrayList<>();
        /**
        At each index in the string, you have two choices:
        -Add '0' ✅ (always allowed)
        -Add '1' ✅ only if the previous character is not '1'
        */
        solve(n, "", ans, '0'); // start with prev = '0' to allow leading '1'
        return ans;
    }
    /**
    n: remaining length to be filled
    current: the string built so far
    result: the final list of valid binary strings
    prev: the last character added (to prevent consecutive '1's)
    */
    private static void solve(int n, String num, List<String> ans, char pre){
        if(n==0){
            ans.add(num);
            return;
        } 
        // Always allowed to add '0'
        solve(n-1, num+'0', ans, '0');
        // Only add '1' if previous character is not '1'
        if(pre!='1'){
            solve(n-1, num+'1', ans, '1');
        }
    }
}
