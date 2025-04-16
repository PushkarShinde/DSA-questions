//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    private int lowerBound(int[] arr, int target){
        int n=arr.length;
        int l=0, r=n;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid]<target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
    private int upperBound(int[] arr, int target){
        int n=arr.length;
        int l=0, r=n;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid]<=target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
    int countFreq(int[] arr, int target) {
        // code here
        int lb=lowerBound(arr, target);
        int ub=upperBound(arr, target);
        return ub-lb;
    }
}
