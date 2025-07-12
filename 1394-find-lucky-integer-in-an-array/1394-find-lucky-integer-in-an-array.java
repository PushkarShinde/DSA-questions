class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int a: arr){
            map.put(a, map.getOrDefault(a,0)+1);
        }

        int maxNum=-1;
        for(int a: map.keySet()){
            if(map.get(a)==a){
                maxNum=Math.max(maxNum, map.get(a));
            }
        }
        return maxNum;
    }
}