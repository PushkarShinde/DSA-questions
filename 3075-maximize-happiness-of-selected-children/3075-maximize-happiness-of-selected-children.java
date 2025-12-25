class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:happiness){
            pq.offer(i);
        }
        long ans=0L;
        for(int i=0;i<k;i++){
            if(pq.peek()-i<=0) break;
            ans+=pq.poll()-i;
        }
        return ans;
    }
}