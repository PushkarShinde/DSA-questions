class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
        int[] res=new int[n];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            int person=heights[i];
            int count=0;
            while(!dq.isEmpty() && dq.peekLast()<person){
                dq.pollLast();
                count++;
            }
            if(!dq.isEmpty()) count++;
            res[i]=count;
            dq.offerLast(person);
        }
        return res;
    }
}