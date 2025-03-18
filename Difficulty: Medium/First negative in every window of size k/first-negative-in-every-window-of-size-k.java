//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

class Solution {

    // Function to find the first negative integer in every window of size k
    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        // write code here
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        if (n < k) {
            return result; // Edge case: if window size is larger than array, return empty list
        }

        // Process the first window
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                queue.offer(arr[i]); // Store value directly instead of index
            }
        }

        // Store result for the first window
        result.add(queue.isEmpty() ? 0 : queue.peek());

        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove the outgoing element if it was negative
            if (!queue.isEmpty() && arr[i - k] == queue.peek()) {
                queue.poll();
            }

            // Add the new element if it's negative
            if (arr[i] < 0) {
                queue.offer(arr[i]);
            }

            // Store result for current window
            result.add(queue.isEmpty() ? 0 : queue.peek());
        }

        return result;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            List<Integer> ans = ob.FirstNegativeInteger(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends