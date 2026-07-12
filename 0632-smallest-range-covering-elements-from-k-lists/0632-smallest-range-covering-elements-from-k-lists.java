class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> a=new ArrayList<>();
        int n=nums.size();
        for(int i=1;i<=n;i++){
            for(int v:nums.get(i-1)){
                a.add(new int[]{v,i});
            }
        }

        a.sort((x,y)-> x[0]-y[0]);

        int l=0;
        int res=Integer.MAX_VALUE;
        int[] range=new int[2];
        Map<Integer, Integer> teams=new HashMap<>();
        
        for(int r=0;r<a.size();r++){
            int[] cur=a.get(r);
            int curVal=cur[0];
            int team=cur[1];

            teams.put(team, teams.getOrDefault(team,0)+1);

            while(teams.size()==n){
                int preTeam=a.get(l)[1];
                int preVal=a.get(l)[0];

                if(res>curVal-preVal){
                    res=curVal-preVal;
                    range=new int[]{preVal,curVal};
                }

                teams.put(preTeam, teams.get(preTeam)-1);
                if(teams.get(preTeam)==0){
                    teams.remove(preTeam);
                }

                l++;
            }
        }

        return range;
    }
}