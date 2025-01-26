//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    void helper(long long n, long long fact, vector<long long>& factorials) {
        if (fact > n){
            return;
        } else{
            factorials.push_back(fact);
            helper(n, fact * (factorials.size()+1), factorials);
        }
    }
    vector<long long> factorialNumbers(long long n) {
        vector<long long> factorials;
        helper(n, 1, factorials); 
        return factorials;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        long long N;
        cin >> N;
        Solution ob;
        vector<long long> ans = ob.factorialNumbers(N);
        for (auto num : ans) {
            cout << num << " ";
        }
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends