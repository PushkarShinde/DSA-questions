//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Solution {
    private int floor(int[] arr,int x){
        int ans=-1;
        int n=arr.length;
        int l=0, r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]<=x){
                ans=arr[mid];
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
    
    private int ceil(int[] arr,int x){
        int ans=-1;
        int n=arr.length;
        int l=0, r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=x){
                ans=arr[mid];
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int[] ans=new int[2];
        ans[0]=floor(arr,x);
        ans[1]=ceil(arr,x);
        
        return ans;
    }
}
