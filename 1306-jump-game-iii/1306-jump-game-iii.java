class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        boolean[] vis=new boolean[n];
        while(!q.isEmpty()){
            int cur=q.poll();
            if(arr[cur]==0){
                return true;
            }
            vis[cur]=true;
            int left=cur-arr[cur];
            if(left>=0 && !vis[left]){
                q.offer(left);
            }
            int right=cur+arr[cur];
            if(right<n && !vis[right]){
                q.offer(right);
            }
        }
        return false;
    }
}