class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a,b)->{
            return a[2]-b[2];
        });
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int[] m: meetings){
            int x=m[0], y=m[1], time=m[2];
            map.computeIfAbsent(time, k-> new HashSet<>()).add(x);
            map.computeIfAbsent(time, k-> new HashSet<>()).add(y);
        }
        Set<Integer> set=new HashSet<>();
        set.add(0);
        set.add(firstPerson);
        for(int key:map.keySet()){
            Set<Integer> val=map.get(key);
            for(int i:set){
                if(val.contains(i)){
                    set.addAll(val);
                    break;
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int s:set){
            res.add(s);
        }
        return res;
    }
}