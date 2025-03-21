//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int n=s.length();
        int start=0, end=0, len=0;
        int maxlen=Integer.MIN_VALUE;
        int freq[]=new int[26];
        int uniqueChar=0;
        while(end<n){
            int index=s.charAt(end)-97;
            if(freq[index]==0){
                uniqueChar++;
            }
            freq[index]++;
            if(uniqueChar==k){
                len=end-start+1;
                maxlen=Math.max(len,maxlen);
            }else if(uniqueChar>k){
                while(start<end && uniqueChar>k){
                    index=s.charAt(start)-97;
                    start++;
                    freq[index]--;
                    if(freq[index]==0){
                        uniqueChar--;
                    }
                }
            }
            end++;
        }
        return (maxlen==Integer.MIN_VALUE)?-1:maxlen;
    }
}