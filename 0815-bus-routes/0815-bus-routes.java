class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target) return 0;

        int n=routes.length;
        Map<Integer, List<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){
            for(int stop:routes[i]){
                map.computeIfAbsent(stop, k-> new ArrayList<>()).add(i);
            }
        }

        int busses=0;
        Queue<Integer> q=new ArrayDeque<>();
        Set<Integer> vis=new HashSet<>();
        Set<Integer> visBus=new HashSet<>();
        vis.add(source);
        q.offer(source);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int cur=q.poll();

                if(cur==target) return busses;

                for(int bus: map.getOrDefault(cur, new ArrayList<>())){
                    if(visBus.contains(bus)) continue;
                    visBus.add(bus);

                    for(int stop: routes[bus]){
                        if(vis.contains(stop)) continue;
                        vis.add(stop);
                        q.offer(stop);
                    }
                }
            }
            busses++;
        }

        return -1;
    }
}