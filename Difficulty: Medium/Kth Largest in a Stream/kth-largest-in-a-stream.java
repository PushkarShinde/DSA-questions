class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        ArrayList<Integer> res=new ArrayList<>(); 
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->a-b);
        int n=arr.length;
        for(int i=0;i<n;i++){
            int cur=arr[i];
            pq.offer(cur);
            int num=-1;
            if(pq.size()>k){
                num=pq.poll();
            }
            
            if(pq.size()==k){
                res.add(pq.peek());
            }else{
                res.add(-1);
            }
        }
        return res;
    }
}