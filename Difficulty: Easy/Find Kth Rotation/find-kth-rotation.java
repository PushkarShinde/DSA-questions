//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Solution {
    public int findKRotation(List<Integer> arr) {
        int n=arr.size();
        int l=0,r=n-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr.get(mid)>arr.get(r)){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}