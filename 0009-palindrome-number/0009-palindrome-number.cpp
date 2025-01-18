class Solution {
public:
    int reverse(int x){
        int result=0;
        while(x){
            int rem=x%10;
            if (result > INT_MAX/10 || result < INT_MIN/10) {
                return 0; // Overflow condition
            }
            result=result*10+rem;
            x/=10; 
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