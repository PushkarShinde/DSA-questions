class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        ArrayList<Integer> res=new ArrayList<>();
        Map<Integer, Integer> fre=new HashMap<>();
        int n=arr.length;
        for(int i:arr){
            fre.put(i,fre.getOrDefault(i, 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry: fre.entrySet()){
            Integer key=entry.getKey();
            Integer val=entry.getValue();
            if(val>n/3){
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }
}