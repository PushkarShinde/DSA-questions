class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Map<Integer> map=new HashMap<>();
        PriorityQueue<Integer> heap=new PriorityQueue<>();//minHeap
        for(int i:nums){
            heap.offer(i);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}