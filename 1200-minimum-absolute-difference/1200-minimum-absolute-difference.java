class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        Map<Integer, List<List<Integer>>> map=new HashMap<>();
        int minDif=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            int d=Math.abs(arr[i]-arr[i-1]);
            List<Integer> list=new ArrayList<>();
            list.add(arr[i-1]);
            list.add(arr[i]);
            map.computeIfAbsent(d, k-> new ArrayList<>())
                .add(new ArrayList<>(list));
            minDif=Math.min(minDif, d);
        }
        // List<List<Integer>> res=map.get(minDif);
        // res.sort((a,b)->{
        //     if(a.get(0)!=b.get(0)) return Integer.compare(a.get(0), b.get(0));
        // });
        // return res;
        return map.get(minDif);
    }
}