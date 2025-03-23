//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    int search(String pat, String txt) {
        // code here
        int n=txt.length();
        int k=pat.length();
        int[] mappat=new int[26];
        int[] maptxt=new int[26];
        for(int i=0;i<k;i++){
            mappat[pat.charAt(i)-'a']++;
            maptxt[txt.charAt(i)-'a']++;
        }
        int count=0;
        if(Arrays.equals(maptxt,mappat)){
            count++;
        }
        for(int i=1;i<n-k+1;i++){
            int add=txt.charAt(i+k-1)-'a';
            int remove=txt.charAt(i-1)-'a';
            maptxt[add]++;
            maptxt[remove]--;
            if(Arrays.equals(maptxt,mappat)){
                count++;
            }
        }
        return count;
    }
}





