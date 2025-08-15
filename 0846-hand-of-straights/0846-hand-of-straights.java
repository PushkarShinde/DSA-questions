class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0) return false;
        TreeMap<Integer, Integer> map=new TreeMap<>();
        for(int i:hand){
            map.put(i, map.getOrDefault(i,0)+1);
        } 
        // int curr=0;
        while (!map.isEmpty()) {
            int first = map.firstKey();
            for(int i=first;i<first+groupSize;i++){
                if(!map.containsKey(i)) return false;
                map.put(i, map.get(i)-1);
                if(map.get(i)<=0) map.remove(i);
            }
        }
        return true;
    }
}