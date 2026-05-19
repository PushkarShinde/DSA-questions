class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        if(n==1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        if(map.size()==1) return 1;

        boolean[] vis=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        vis[0]=true;

        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            step++;

            while(size-->0){
                int cur=q.poll();

                List<Integer> vals= new ArrayList<>();

                if(cur>0) vals.add(cur-1); 
                if(cur<n-1) vals.add(cur+1); 

                if(map.containsKey(arr[cur])){
                    vals.addAll(map.get(arr[cur]));
                    map.remove(arr[cur]);
                }

                for(int v:vals){
                    if(v==n-1) return step;
                    if(!vis[v]){
                        vis[v]=true;
                        q.offer(v);
                    }
                }
            }
        }
        return -1;
    }
}