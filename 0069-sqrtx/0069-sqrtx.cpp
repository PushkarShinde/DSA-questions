class Solution {
public:
    int mySqrt(int x) {
        size_t i;
        for(i=0;i*i<=x;i++){}
        return i-1;
    }
};