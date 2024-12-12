class Solution {
public:
    long long pickGifts(vector<int>& gifts, int k) {
        for(int i=0;i<k;i++){
            auto max= max_element(gifts.begin(),gifts.end());
            replace(gifts.begin(),gifts.end(),*max,(int)sqrt(*max));
        }
        long long sum=0;
        for(auto gift : gifts){
            sum+=gift;
        }
        return sum;
    }
};