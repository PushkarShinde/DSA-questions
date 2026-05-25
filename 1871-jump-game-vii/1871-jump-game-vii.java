class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        Set<Integer> set=new HashSet<>();
        set.add(0);

        int farthest=0;

        while(!q.isEmpty()){
            int cur=q.poll();
            if(cur==n-1) return true;
            int start=Math.max(cur+minJump, farthest-1);
            int end=Math.min(cur+maxJump, n-1);
            for(int i=start; i<=end; i++){
                if(s.charAt(i)=='0' && !set.contains(i)){
                    q.offer(i);
                    set.add(i);
                }
            }
            farthest=end;
        }
        return false;
    }
}