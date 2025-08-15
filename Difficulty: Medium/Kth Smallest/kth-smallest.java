// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        
        for(int i:arr){
            maxHeap.offer(i);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
