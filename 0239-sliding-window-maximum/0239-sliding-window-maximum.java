class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        // TC: O(n), SC: O((k)
        if(n==0) return res;
        Deque<Integer> deque=new ArrayDeque<Integer>();
        int ind=0;
        while(ind<k){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[ind]){
                deque.pollLast(); // agar ane wale number se existing chota ya uske jitna hai toh hata do! 
            }
            deque.offerLast(ind);
            ind++;
        }
        res[0]=nums[deque.peekFirst()]; // first window ke max ko resultant array me dala
        for(int i=1;i<n-k+1;i++){ // age ane wale windows
            while(!deque.isEmpty() && deque.peekFirst()<i){
                deque.pollFirst(); 
                // existing window ke starting index ko hata denge agar vo new window ke start se chota ho
            } 
            int newInd=i+k-1;
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[newInd]){
                deque.pollLast();
            }
            deque.offerLast(newInd); // window ko age badhayenge!
            res[i]=nums[deque.peekFirst()];
        }
        return res;
    }
}