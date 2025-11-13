class Solution {
    public int maxOperations(String s) {
        List<Integer> one=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1') one.add(i);
        }
        int cost=0;
        for(int i=0;i<one.size()-1;i++){
            int pre=one.get(i);
            int post=one.get(i+1);
            if(pre+1!=post){
                cost+=i+1;
            }
        }
        int m=one.size();
        if(m!=0 && one.get(m-1)!=n-1){
            cost+=one.size();
        }
        return cost; 
    }
}