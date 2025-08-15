class Solution {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:arr){
            pq.offer(i);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=pq.poll();
        }
    }
}
