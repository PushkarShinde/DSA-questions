class Solution {
    public int josephus(int n, int k) {
        List<Integer> list=new LinkedList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int i=(k-1)%n;
        while(list.size()>1){
            list.remove(i);
            i+=(k-1);
            i%=list.size();
        }
        return list.get(list.size()-1);
    }
}