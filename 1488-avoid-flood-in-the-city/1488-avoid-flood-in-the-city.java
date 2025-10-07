class Solution {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length;
        int[] res=new int[n];
        // Map: lake -> last day it rained
        Map<Integer, Integer> map=new HashMap<>();
        // TreeSet to store available dry days (sorted)
        TreeSet<Integer> dryDays = new TreeSet<>();
        for(int day=0;day<n;day++){
            if(rains[day]==0){
                dryDays.add(day);
                res[day]=1;
            }else{
                int lake=rains[day];
                res[day]=-1;
                if(map.containsKey(lake)){
                    int lastRained=map.get(lake);
                    Integer dryDay=dryDays.ceiling(lastRained);
                    if(dryDay==null || dryDay>day){
                        return new int[]{};
                    }
                    res[dryDay]=lake;
                    dryDays.remove(dryDay);
                }
                map.put(lake,day);
            }
        }
        return res;   
    }
}