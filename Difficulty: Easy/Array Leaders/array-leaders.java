//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            List<Integer> result = new Solution().leaders(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();    // Ensure new line after each test case output
                System.out.println("~"); // Ensure new line after each test case output
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    static void reverse(ArrayList<Integer> arr, int l, int r){
        while (l < r) {
            int temp = arr.get(l);
            arr.set(l, arr.get(r));
            arr.set(r, temp);
            l++;
            r--;
        }
    }
    static ArrayList<Integer> leaders(int arr[]) {
        int n=arr.length;
        int i=n-2;
        ArrayList<Integer> leader=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        leader.add(arr[n-1]);
        int max=arr[n-1];
        while(i>=0){
            max=Math.max(max, arr[i]);
            if(arr[i]==max) leader.add(arr[i]);
            i--;
        }
        reverse(leader, 0,leader.size()-1);
        return leader;
    }
}
