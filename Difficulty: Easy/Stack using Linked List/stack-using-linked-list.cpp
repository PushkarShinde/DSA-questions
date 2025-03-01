//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct StackNode {
    int data;
    StackNode *next;

    StackNode(int a) {
        data = a;
        next = NULL;
    }
};


// } Driver Code Ends

class MyStack {
  private:
    StackNode *top;

  public:
    void push(int x) {
        // code here
        StackNode* newNode = new StackNode(x);  // Allocate new node
        newNode->next = top;  // Link to current top
        top = newNode;  // Update top to new node
    }

    int pop() {
        // code here
        if (top == nullptr) {  // Check if stack is empty
            return -1;  // Return -1 as specified for empty stack
        }
        StackNode* temp = top;  // Store current top
        int val = temp->data;  // Get the value to return
        top = top->next;  // Move top to next node
        delete temp;  // Free memory to prevent leaks
        return val;  // Return the popped value
    }

    MyStack() { top = nullptr; }
};



//{ Driver Code Starts.

int main() {
    int T;
    cin >> T;
    cin.ignore();
    while (T--) {
        MyStack *sq = new MyStack();
        string line;
        getline(cin, line);
        stringstream ss(line);
        vector<int> nums;
        int num;
        while (ss >> num) {
            nums.push_back(num);
        }
        int n = nums.size();
        int i = 0;
        while (i < n) {
            int QueryType = nums[i++];
            if (QueryType == 1) {
                int a = nums[i++];
                sq->push(a);
            } else if (QueryType == 2) {
                cout << sq->pop() << " ";
            }
        }
        cout << endl;
        cout << "~"
             << "\n";
        delete sq;
    }
}

// } Driver Code Ends