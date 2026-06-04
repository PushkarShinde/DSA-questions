class Solution {
    public int totalWaviness(int a, int b) {
        int res=0;
        for(int i=a;i<=b;i++){
            res+=count(i);
        }
        return res;
    }
    private int count(int num){
        List<Integer> list=new ArrayList<>();

        while(num>0){
            int d=num%10;
            num/=10;
            list.add(d);
        }
        int res=0;
        for(int i=1;i<list.size()-1;i++){
            int x=list.get(i-1);
            int y=list.get(i);
            int z=list.get(i+1);
            if((y>x && y>z) || (y<x && y<z)) res++;
        }
        return res;
    }
}