//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int maxLen=0;
        int n=arr.length;
        int sum=0;
        /*Works for all positive and non positive elements*/
        HashMap<Integer,Integer> prefixSum=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==k){maxLen=Math.max(maxLen,i+1);}
            
            if(prefixSum.containsKey(sum-k)){
                maxLen=Math.max(maxLen,i-prefixSum.get(sum-k));
            }
            if(!prefixSum.containsKey(sum)){
                prefixSum.put(sum,i);
            }
        }
        
        /*
        Works only when there are positive elements in the array!!
        // int l=0,r=0;
        // int sum=0;
        // while(r<n){
        //     sum+=arr[r];
        //     while(sum>k){
        //         sum-=arr[l];
        //         l++;
        //     }
        //     if(sum==k){maxLen=Math.max(maxLen,r-l+1);}
        //     r++;
        // }
        */
        return maxLen;
    }
}








