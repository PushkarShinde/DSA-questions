class Solution {
    public int minGenerations(int[][] points, int[] target) {
        Set<String> set=new HashSet<>();
        List<int[]> curGen= new ArrayList<>();
        for(int[] p:points){
            curGen.add(p);
            set.add(pointToString(p));
            if(isEqual(p,target)){
                return 0;
            }
        }
        
        if(points.length==1) return -1;

        int gen=0;
        while(gen<15){
            gen++;
            List<int[]> nextGen=new ArrayList<>();
            for(int i=0;i<curGen.size();i++){
                for(int j=i+1;j<curGen.size();j++){
                    int[] mid=midPoint(curGen.get(i),curGen.get(j));
                    String key=pointToString(mid);
                    if(!set.contains(key)){
                        set.add(key);
                        nextGen.add(mid);
                        if(isEqual(mid,target)){
                            return gen;
                        }
                    }
                }
            }
            if(nextGen.isEmpty()) return -1;
            curGen.addAll(nextGen);
        }
        return -1;
    }
    private int[] midPoint(int[] a, int[] b){
        return new int[]{
            (a[0]+b[0])/2, 
            (a[1]+b[1])/2,
            (a[2]+b[2])/2
        };
    }
    private String pointToString(int[] p){
        String key=p[0]+","+p[1]+","+p[2];
        return key;
    }
    private boolean isEqual(int[] a, int[] b){
        return a[0]==b[0] && a[1]==b[1] && a[2]==b[2];
    }
}