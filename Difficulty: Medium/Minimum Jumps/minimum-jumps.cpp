//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// Function to return minimum number of jumps to end of array

class Solution {
  public:
    int minJumps(vector<int>& arr) {
        int n = arr.size();
        
        // Edge case: if only one element, no jumps needed
        if (n == 1) return 0;
        
        // Edge case: if first element is 0, can't move forward
        if (arr[0] == 0) return -1;
        
        int maxReach = arr[0]; // The farthest index reachable
        int steps = arr[0];    // Steps left in the current range
        int jumps = 1;         // At least one jump is required

        for (int i = 1; i < n; i++) {
            // If we have reached the last index
            if (i == n - 1) return jumps;

            // Update the maximum reach
            maxReach = max(maxReach, i + arr[i]);
            
            // Use a step
            steps--;

            // If no steps are left
            if (steps == 0) {
                jumps++; // Take another jump

                // If current index exceeds maxReach, we can't proceed
                if (i >= maxReach) return -1;

                // Reset steps to the new range
                steps = maxReach - i;
            }
        }

        return -1; // If end is not reachable
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        int n, i, j;
        vector<int> arr;
        string ip;
        int number;
        getline(cin, ip);
        stringstream ss(ip);

        while (ss >> number) {
            arr.push_back(number);
        }
        Solution obj;
        cout << obj.minJumps(arr) << endl << "~\n";
    }
    return 0;
}

// } Driver Code Ends