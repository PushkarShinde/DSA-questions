class Solution {
public:
    int mySqrt(int x) {
        size_t i=0;
        while(i*i<=x){
            i++;
        }
        return i-1;
    }
};