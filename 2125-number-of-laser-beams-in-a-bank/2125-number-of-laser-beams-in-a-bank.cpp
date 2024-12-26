class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        int count=0;
        vector<int> weight;
        for(int i = 0; i < bank.size(); i++) {
            for(auto j: bank[i]) {
                if(j == '1') {
                    count++;
                }
            }
            if(count != 0) {
                weight.push_back(count);
            }
            count = 0;  // Reset count for the next row
        }
        
        if (weight.size() < 2) {
        return 0; // If less than 2 valid rows, no connections are possible
        }

        int c=0;
        for(int i=0;i<weight.size()-1;i++){
            c+=weight[i]*weight[i+1];
        }
        return c;
    }
};