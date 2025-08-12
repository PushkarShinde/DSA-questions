// User function Template for Java

class Solution {
    
    //Steps:

Find the index of the last non-leaf node:

lastNonLeaf
=
⌊
𝑛
/
2
⌋
−
1
lastNonLeaf=⌊n/2⌋−1
For each index i from lastNonLeaf down to 0:

Call maxHeapify(arr, n, i) to fix the max-heap property.
*/
    static void convertMinToMaxHeap(int n, int arr[]) {
        for(int i=n/2-1;i>=0;i--){
            maxHeapify(n,arr,i);
        }
    }
    private static void maxHeapify(int n, int arr[], int k){
        int largest=k;
        int left=k*2+1;
        int right=k*2+2;
        
        if(left<n && arr[largest]<arr[left]){
            largest=left;
        }
        if(right<n && arr[largest]<arr[right]){
            largest=right;
        }
        
        if(largest!=k){
            swap(largest,k,arr);
            maxHeapify(n,arr,largest);
        }
    }
    private static void swap(int a, int b, int[] arr){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
