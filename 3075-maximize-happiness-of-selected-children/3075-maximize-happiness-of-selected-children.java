class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:happiness){
            pq.offer(i);
        }
        long ans=0L;
        for(int i=0;i<k;i++){
            ans+=Math.max(pq.poll()-i,0);
        }
        return ans;
    }
}