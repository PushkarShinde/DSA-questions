class Solution {
public:
    int reverse(int x){
        int result=0;
        while(){
            int rem=%10;
            if (result > INT_MAX/10 || result < INT_MIN/10) {
                return 0; // Overflow condition
            }
            result=result*10+rem;
            /=10; 
        }
        return result;
    }
    bool isPalindrome(int x) {
        if(x<0){
            return false;
        }
        return reverse(x)==x;
    }
};